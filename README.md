# 🗣️ TalkStep — AI-Powered English Tutor & RAG Platform

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.5-brightgreen?style=for-the-badge&logo=springboot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-8.4-blue?style=for-the-badge&logo=mysql&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-JPA-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![OAuth2](https://img.shields.io/badge/OAuth2-Google%20Auth-red?style=for-the-badge&logo=google&logoColor=white)

O **TalkStep** (`talkstep-backend`) é uma plataforma backend desenvolvida em **Java** e **Spring Boot** que atua como um tutor de inglês automatizado e personalizado. O sistema combina **Modelos de Linguagem (LLMs)**, **RAG (Retrieval-Augmented Generation)** e processamento de áudio para guiar o estudante em planos de estudo estruturados, oferecendo correção gramatical contextualizada e prática de conversação.

---

## 🎯 Problema e Solução

Estudantes de idiomas frequentemente enfrentam dificuldades para manter uma rotina estruturada de prática ativa (escrita e fala) com feedback imediato e alinhado ao seu nível de proficiência. O **TalkStep** resolve esse gargalo atuando como o motor pedagógico da aplicação, estruturando:

* **Trilhas de Aprendizagem (Itineraries):** Planos de estudo divididos por nível **CEFR** (`A1` a `C2`), módulos e tópicos com foco gramatical e vocabular.
* **Sessões de Estudo Contínuas:** Histórico de aulas (`Lesson`) que registra resumos anteriores, pontos fracos do aluno e evolução por tópico.
* **Tutoria com IA & RAG:** Ingestão de materiais didáticos em PDF convertidos em *embeddings* vetoriais para fundamentar as respostas e correções do tutor.
* **Prática Multimodal (Escrita e Conversação):** Análise de mensagens de texto com correções gramaticais detalhadas e suporte a fluxos de áudio (*Speech-to-Text* e *Text-to-Speech*).

---

## 🛠️ Tecnologias e Ferramentas

* **Linguagem:** Java 21
* **Framework:** Spring Boot 3.2.5
* **Segurança & Autenticação:** Spring Security / OAuth2 Client (Login com Google e autenticação local)
* **Persistência de Dados:** Spring Data JPA / Hibernate
* **Banco de Dados:** MySQL 8.4 (Hospedado em nuvem via **Aiven Cloud**)
* **Inteligência Artificial:** Integração com LLMs e arquitetura RAG (Vector Embeddings)
* **Build & Dependências:** Maven

---

## 🏗️ Arquitetura do Projeto

O sistema segue a arquitetura em camadas do Spring Boot aliada aos princípios de **Clean Code** e **SOLID**, garantindo baixo acoplamento e alta coesão entre o domínio pedagógico e as integrações de IA:

```text
talkstep-backend/
├── src/main/java/com/talkstep/api/
│   ├── controller/       # Endpoints REST (Itinerários, Lições, Chat e Upload de Materiais)
│   ├── service/          # Regras de negócio, orquestração de prompts e pipeline RAG
│   ├── repository/       # Interfaces Spring Data JPA para persistência no MySQL
│   ├── domain/
│   │   ├── entity/       # Entidades de domínio (User, Itinerary, ModuleTopic, Lesson, ChatMessage, Material)
│   │   └── enums/        # Enumerações de domínio (CefrLevel, AuthProvider)
│   └── dto/              # Data Transfer Objects para requisições e respostas da API
└── src/main/resources/
    └── application.properties
📊 Principais Funcionalidades
Gestão de Usuários e Autenticação: Suporte a cadastro local e autenticação social via Google OAuth2 (AuthProvider).

Trilhas Personalizadas por Nível CEFR: Organização hierárquica de User ➔ Itinerary ➔ ModuleTopic ➔ Lesson.

Histórico Inteligente de Conversação (ChatMessage): Armazenamento das interações entre aluno e tutor com registro dedicado para correções gramaticais e URLs de áudio.

Base de Conhecimento via PDF (RAG): Upload de apostilas e materiais didáticos (Material) fragmentados em chunks vetoriais (material_chunk) para consultas semânticas.

Módulo de Conversação por Voz (STT / TTS): (Em desenvolvimento) Transcrição de fala do aluno e síntese de voz do tutor.

🚀 Como Executar o Projeto Localmente
Pré-requisitos
JDK 21 instalado

Maven instalado (ou uso do wrapper ./mvnw)

Instância MySQL 8+ (local ou Aiven Cloud)

Passos
Clonar o repositório:

Bash
git clone [https://github.com/BarbosaJacson/talkstep-backend.git](https://github.com/BarbosaJacson/talkstep-backend.git)
cd talkstep-backend
Configurar as variáveis de ambiente e banco de dados:
Ajuste as credenciais no arquivo src/main/resources/application.properties (ou defina as variáveis de ambiente DB_USERNAME e DB_PASSWORD):

Properties
spring.application.name=talkstep-backend

spring.datasource.url=jdbc:mysql://localhost:3306/db_TalkStep?createDatabaseIfNotExist=true&serverTimezone=America/Sao_Paulo
spring.datasource.username=${DB_USERNAME:root}
spring.datasource.password=${DB_PASSWORD:sua_senha}

spring.jpa.hibernate.ddl-auto=update
Executar a aplicação:

Bash
mvn spring-boot:run
A API estará disponível em http://localhost:8080.

---

---

### 👨‍💻 Desenvolvido por Jacson Barbosa

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/jacson-barbosa-7a080a308/)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/BarbosaJacson)
