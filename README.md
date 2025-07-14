#  Conversor de Moedas - Programa ONE (Oracle Next Education)

##  Descrição do Projeto

Este projeto foi desenvolvido como parte da formação em Java e Orientação a Objetos do Programa ONE (Oracle Next Education), uma parceria entre a Oracle e a Alura. O objetivo foi criar um conversor de moedas que consome dados de uma API externa para fornecer cotações atualizadas.

##  Funcionalidades

- Conversão entre 6 pares de moedas diferentes
- Consulta em tempo real das taxas de câmbio
- Interface amigável via linha de comando
- Tratamento de erros robusto
- Arquitetura limpa e organizada

##  Tecnologias Utilizadas

- Java 17+
- HTTP Client API (java.net.http)
- Gson para manipulação de JSON
- Paradigma de Orientação a Objetos
- Records para DTOs
- Tratamento de exceções customizadas

##  Como Executar o Projeto

### Pré-requisitos

- JDK 17+ instalado
- Dependência Gson adicionada ao projeto
- Chave de API válida do [ExchangeRate-API](https://www.exchangerate-api.com/)

### Passo a Passo

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/conversor-moedas.git
   ```

2. Baixe o arquivo JAR do Gson:
   [Download Gson 2.10.1](https://repo1.maven.org/maven2/com/google/code/gson/gson/2.10.1/gson-2.10.1.jar)

3. Adicione manualmente ao classpath:
   ```bash
   javac -cp ".;gson-2.10.1.jar" src/br/com/devjany/conversordemoedas/*.java
   java -cp ".;gson-2.10.1.jar" br.com.devjany.conversordemoedas.ConversorMoedasApp
   ```

4. Configure sua API Key:
   - Abra o arquivo `src/br/com/devjany/conversordemoedas/config/ApiConfig.java`
   - Substitua `"SUA_API_KEY_AQUI"` pela sua chave
     

##  Estrutura do Projeto

```
src/
└── br/
    └── com/
        └── devjany/
            └── conversordemoedas/
                ├── api/
                │   ├── ExchangeRateApiClient.java
                │   └── dto/
                │       ├── ExchangeRateResponse.java
                │       └── CurrencyConversion.java
                ├── config/
                │   └── ApiConfig.java
                ├── exception/
                │   ├── ApiConnectionException.java
                │   └── CurrencyConversionException.java
                ├── service/
                │   ├── CurrencyConverterService.java
                │   └── MenuService.java
                └── ConversorMoedasApp.java
```

##  Aprendizados da Formação Java e Orientação a Objetos 

Durante o desenvolvimento deste projeto, apliquei vários conceitos ensinados na formação:

1. **Orientação a Objetos**: Encapsulamento, composição e separação de responsabilidades
2. **Records**: Para criação de DTOs imutáveis
3. **Tratamento de Exceções**: Criação de exceções customizadas
4. **Consumo de APIs**: Uso do HttpClient para requisições HTTP
5. **Manipulação de JSON**: Com a biblioteca Gson
6. **Boas Práticas**: Clean Code, princípios SOLID e organização de pacotes

##  Melhorias Futuras

- [ ] Adicionar mais pares de moedas
- [ ] Implementar cache das cotações
- [ ] Criar interface gráfica
- [ ] Adicionar histórico de conversões
- [ ] Permitir conversão entre quaisquer moedas, não apenas com o dólar como intermediário

##  Agradecimentos

Agradeço à Oracle e à Alura pela oportunidade de participar do Programa ONE e por fornecerem conteúdo de alta qualidade para o aprendizado de Java e Orientação a Objetos.

---

Desenvolvido como parte do Programa ONE - Oracle Next Education  
© 2025 - Todos os direitos reservados
