package com.dashboardaf.backend.service;

import com.dashboardaf.backend.dto.AttendanceDTO;
import com.dashboardaf.backend.dto.RecentAttendanceDTO;
import com.dashboardaf.backend.entity.Attendance;
import com.dashboardaf.backend.repository.AttendanceRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    private final String apiUrl = "https://saudetransparente2.sjp.pr.gov.br/saudetransparenteapi/saude-transparente/atendimento-farmaceuticos/buscar-dados-farmaceuticos";
    private final String healthUnitsJsonPath = "src/main/resources/healthUnits.json";

    @Scheduled(fixedRate = 60000)
    public void scrapeData() {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            List<Map<String, Object>> healthUnits = objectMapper.readValue(
                    Paths.get(healthUnitsJsonPath).toFile(), new TypeReference<List<Map<String, Object>>>() {});

            LocalDateTime now = LocalDateTime.now();

            for (Map<String, Object> unit : healthUnits) {
                int unitId = (int) unit.get("id");
                String unitName = (String) unit.get("name");

                AttendanceDTO payload = new AttendanceDTO(now.toLocalDate(), now.toLocalDate(), false, List.of(new AttendanceDTO.Unit(unitId)), null);
                AttendanceDTO response = restTemplate.postForObject(apiUrl, payload, AttendanceDTO.class);

                if (response != null && response.getRetorno() != null) {
                    double quantidade = response.getRetorno().stream()
                            .filter(item -> "Usuários atendidos no período informado".equals(item.getTitulo()))
                            .findFirst()
                            .map(AttendanceDTO.Retorno::getQuantidade)
                            .orElse(0.0);

                    Attendance attendance = new Attendance(unitId, now, unitName, quantidade);

                    attendanceRepository.save(attendance);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<RecentAttendanceDTO> getMaxQuantitiesForToday() {
        LocalDateTime startOfDay = LocalDateTime.now().toLocalDate().atStartOfDay();
        LocalDateTime endOfDay = LocalDateTime.now();

        List<Object[]> results = attendanceRepository.findMaxQuantitiesForToday(startOfDay, endOfDay);
        return results.stream()
                .map(result -> new RecentAttendanceDTO((Integer) result[0], (Double) result[1]))
                .collect(Collectors.toList());
    }
}