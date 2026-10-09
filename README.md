# Connectivity Forecast API

Reimplementação Java/Spring Boot da [API de referência](https://github.com/LiniiS/connectivity-forecast-api), usada como artefato educacional de APS II.

## Executar

Requisitos: Java 17 e Maven 3.9+.

```bash
mvn test
mvn spring-boot:run
```

Swagger UI: `http://localhost:8080/swagger-ui.html`  
OpenAPI: `http://localhost:8080/v3/api-docs`

## Escopo

API local com catálogo de modelos e previsões mockadas. Fixture igual à referência: 4 modelos ativos, 10 probes e 24 instantes (960 previsões); catálogo também contém modelo inativo. Dados fictícios. Não consulta RIPE Atlas, não treina nem executa modelos, não usa banco de dados e não exige deploy. Classificação e recomendações são regras experimentais, não padrões científicos.

## Estrutura

Separação em controllers, services, repositories, modelos de domínio/DTOs e configuração. API versionada em `/api/v1`, com recursos de health, modelos, localizações, previsões e atividades.

## Documentação

A API disponibiliza documentação interativa por meio do Swagger UI e a especificação OpenAPI.

- **Swagger UI:** http://localhost:8080/swagger-ui.html
- **OpenAPI:** http://localhost:8080/v3/api-docs

Para consultar a documentação, inicie a aplicação com `mvn spring-boot:run` e acesse um dos endereços acima.

### Pontos de atenção

- O README e a documentação OpenAPI são pontos de partida para conhecer a API.
- A documentação dos endpoints ainda pode ser ampliada com descrições de parâmetros, validações, exemplos de requisições e respostas, códigos de erro e origem dos campos.
- Os dados de modelos e previsões são fictícios e utilizados como exemplos locais.
- A API não consulta o RIPE Atlas, não treina nem executa modelos de previsão e não utiliza banco de dados.
- As classificações e recomendações possuem caráter experimental e não devem ser interpretadas como resultados científicos validados.

A referência à licença MIT da API de origem é preservada neste projeto, conforme registrado em `THIRD_PARTY_NOTICES.md`.
