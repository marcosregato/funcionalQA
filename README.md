# FuncionalQA - Test Automation Framework

> Framework moderno de teste funcional para aplicações web, parte da arquitetura QA.
> **Versão 2.0** - Modernizado com melhores práticas e tecnologias atuais

> __Mais Informações sobre a Arquitetura QA__

>	Email = marcosregato01@gmail.com
>	Assunto = Arquitetura QA

> __Descrição do projeto__

>	Framework robusto e escalável para automação de testes funcionais web, desenvolvido com padrões modernos e melhores práticas de automação.

>	**Diagrama da Arquitetura:** </br>
>	Para visualizar a arquitetura completa em formato interativo, consulte o arquivo `diagrama.md` que contém diagramas Mermaid detalhados da estrutura e fluxo de execução.</br>

> **Tecnologias e Ferramentas** </br>
> * **Java 11** - Linguagem moderna e performática
> * **JUnit 5** - Framework de testes atualizado
> * **Selenium 4** - WebDriver mais recente e estável
> * **Cucumber 7** - BDD com suporte a Gherkin
> * **Allure Reports** - Relatórios interativos e ricos
> * **Log4j2** - Logging estruturado e seguro
> * **Maven** - Gerenciamento de dependências e build
> * **WebDriverManager** - Setup automático de drivers
> * **Gson** - Processamento JSON moderno </br>

> **Características Principais** </br>
> * **Thread-Safe** - Suporte para execução paralela
> * **Page Object Pattern** - Arquitetura limpa e manutenível
> * **Waits Explícitos** - Sincronização inteligente de elementos
> * **Relatórios Modernos** - Screenshots, logs e métricas detalhadas
> * **Logging Profissional** - Estruturação completa de logs
> * **Tratamento Robusto** - Exceções customizadas e recuperação
> * **Configuração Flexível** - Properties e ambiente configuráveis </br>


# Modo de Execução

>	Para executar os testes, utilize as seguintes opções:

## **Execução Maven (Recomendado)**

```bash
# Executar todos os testes
mvn test

# Executar com relatórios Allure
mvn clean test allure:serve

# Executar teste específico
mvn test -Dtest=TC_001_PaginaPrincipal

# Executar em paralelo
mvn test -Dparallel=methods -DthreadCount=4
```

## **Execução IDE**

>	Os testes podem ser executados via JUnit 5 ou Cucumber 7:

> **JUnit 5 - RunnerTestJunit** </br>
> 	Execute a classe `TC_001_PaginaPrincipal` diretamente na IDE.
> 	Utiliza anotações modernas JUnit 5 com DisplayName e estrutura melhorada.

> **Cucumber 7 - RunnerTestCucumber** </br>
> 	Execute via BDD com arquivos `.feature` na pasta `features/`.
> 	Steps implementados em `src/test/java/steps/`.

## **Configuração**

>	No arquivo `config.properties` você pode configurar:

```properties
# URL da aplicação
URL = http://automationpractice.com/index.php

# Browser (FIREFOX/CHROME)
browser = FIREFOX

# Tempo de espera em segundos
tempo.espera = 10

# Texto para pesquisa
txt.pesquisar = blouse

# Execução headless (opcional)
headless = false

# Runner de teste
runner.test = RunnerTestJunit
```

# Relatórios e Evidências

## **Allure Reports (Principal)**
>	Relatórios modernos e interativos gerados automaticamente:

```bash
# Gerar e visualizar relatórios
mvn allure:serve

# Gerar relatório estático
mvn allure:report
```

**Características dos Relatórios:**
- Screenshots automáticos em cada step
- Timeline detalhada de execução
- Logs estruturados e mensagens de erro
- Informações de ambiente e dados de teste
- Gráficos e estatísticas de performance

## **CSV Legacy (Compatibilidade)**
>	Para compatibilidade, ainda gera CSV na pasta `FERRAMENTA_TESTE/`:

> 	Estrutura do CSV:
> 	Status,Data,Hora,Metodo,Mensagem Erro
> 	OK,26-04-2026,09:15,cenarioTestePesquisar,Teste executado com sucesso
> 	ERRO,26-04-2026,09:16,cenarioTestePesquisarComTexto,Elemento não encontrado

## **Logs Estruturados**
>	Logs detalhados gerados em `logs/`:
- `test-execution.log` - Log principal
- `test-rolling-YYYY-MM-DD-i.log` - Logs rotativos
- Console output em tempo real


# Linha de Comandos

## **Análise de Código**

> __SonarQube__ </br>

> 	mvn sonar:sonar -Dsonar.host.url=http://localhost:9000
> 	ou
> 	mvn clean verify sonar:sonar

## **Build e Deploy**

```bash
# Compilar projeto
mvn clean compile

# Executar todos os testes
mvn clean test

# Gerar relatórios e análise
mvn clean test sonar:sonar allure:report

# Empacotar aplicação
mvn clean package
```

# Arquitetura do Projeto

## **Estrutura de Diretórios**

```
src/test/java/
|-- base/
|   |-- BaseTest.java              # Classe base com setup/teardown
|-- browser/
|   |-- Browser.java               # ThreadLocal WebDriver management
|-- config/
|   |-- ConfigProperties.java      # Gerenciamento de configurações
|   |-- RunnerTestJunit.java       # Runner JUnit 5
|   |-- RunnerTestCucumber.java    # Runner Cucumber 7
|-- pages/
|   |-- BasePage.java             # Base para Page Objects
|   |-- MainPage.java             # Page Object principal
|-- reporting/
|   |-- AllureReporter.java       # Relatórios Allure
|-- steps/
|   |-- ElementPag.java           # Steps Cucumber
|-- util/
|   |-- WaitManager.java          # Waits explícitos
|   |-- Validacao.java            # Validações
|-- api/
|   |-- ResponseAPI.java          # API utilities
|-- cenarioTeste/
|   |-- TC_001_PaginaPrincipal.java # Testes modernizados
```

## **Padrões Implementados**

- **Page Object Pattern** - Separação entre lógica e interação UI
- **Thread-Safe Design** - Suporte para execução paralela
- **Explicit Waits** - Sincronização inteligente
- **Logging Estruturado** - Log4j2 com múltiplos appenders
- **Exception Handling** - Exceções customizadas e recuperação
- **Configuration Management** - Properties com defaults

# Links dos Projetos da Arquitetura

> **Ecoistema QA - Projetos Relacionados**

> __Teste Funcional QA__ (este projeto)
> [Link do projeto](https://github.com/marcosregato/funcionalQA)</br>

> __Painel Teste Angular__
> [Link do projeto](https://github.com/marcosregato/painelTesteQA)</br>

> __Teste API QA__
> [Link do projeto](https://github.com/marcosregato/testeApiQA)</br>

> __convert CSV to JSON__
> [Link do projeto](https://github.com/marcosregato/convertCSVtoJSON)</br>

> __Data Science QA__
> [Link do projeto](https://github.com/marcosregato/dataScienceQA)</br>

> __Api QA__
> [Link do projeto](https://github.com/marcosregato/apiQA)</br>

> __Test Api QA__
> [GitHub Pages](https://github.com/marcosregato/testApiQA)</br>

> __Gerador massa de dados QA__
> [Link do projeto](https://github.com/marcosregato/geradorMassaQA)</br>

# Contribuição

>	Para contribuir com o projeto:
>	1. Fork o repositório
>	2. Crie branch para sua feature (`git checkout -b feature/nova-funcionalidade`)
>	3. Commit suas mudanças (`git commit -m 'Adicionando nova funcionalidade'`)
>	4. Push para o branch (`git push origin feature/nova-funcionalidade`)
>	5. Abra um Pull Request

# Licença

>	Este projeto faz parte da arquitetura QA desenvolvida por Marcos Regato.
>	Contato: marcosregato01@gmail.com
