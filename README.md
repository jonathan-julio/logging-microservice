# logging-microservice Repository

Este é um repositório de microsserviço de log que recebe e armazena logs em um banco de dados MongoDB. O microsserviço também se integra a um serviço RabbitMQ para receber logs assincronamente.

Pré-requisitos
Antes de executar o projeto, certifique-se de ter as seguintes dependências instaladas e configuradas:


MongoDB (Sem autenticação)
RabbitMQ 
Configuração
Clone o repositório para o seu ambiente local:
bash
Copy code
git clone https://github.com/jonathan-julio/logging-microservice.git
Configure as propriedades de conexão com o MongoDB e RabbitMQ no arquivo application.properties. Por exemplo:<br><br>
#Configurações do MongoDB<br>
spring.data.mongodb.host=localhost<br>
spring.data.mongodb.port=27017<br>
spring.data.mongodb.database=test<br><br>

#Configurações do RabbitMQ<br>
spring.rabbitmq.host=localhost<br>
spring.rabbitmq.port=5672<br>
spring.rabbitmq.username=admin<br>
spring.rabbitmq.password=password_123<br><br>
Execute o aplicativo:
F5 no vc code
O aplicativo será iniciado e estará pronto para receber logs através do RabbitMQ.

Envio de logs
Os logs devem ser enviados para a fila do RabbitMQ com o nome vascobank.logs. Você pode usar qualquer cliente RabbitMQ para enviar logs para essa fila.

O formato esperado para os logs é um objeto JSON com as seguintes propriedades:

json<br>
{<br>
  "timestamp": "01.02.2021 21.03:48.357",<br>
  "level": "INFO",<br>
  "microservice": "Autenticacao",<br>
  "thread": "main",<br>
  "class": "JsonLogApplicationKt",<br>
  "method": "info",<br>
  "message": "Starting JsonLogApplicationKt using Java 15.0.1 on vortex.fritz.box wit",<br>
  "context": "default",<br>
  "ip": "127.0.0.1"<br>
}<br>
O aplicativo irá processar os logs recebidos, salvar no banco de dados MongoDB e imprimir uma mensagem indicando o salvamento bem-sucedido.

Recuperação de logs
Você pode recuperar os logs armazenados no banco de dados usando as operações fornecidas pelo repositório LogRepository. As consultas suportadas incluem filtragem por intervalo de datas, nível de log, microserviço, thread, classe e método.
exemplo de get: <br>
http://localhost:8080/api/logs/timestamp/01.02.2021/31.02.2021?user=root&password=password_123<br>
http://localhost:8080/api/logs/level/INFO/01.02.2021/31.02.2021?user=root&password=password_123<br><br>
Processamento de logs pendentes
Se ocorrer uma falha na conexão com o banco de dados MongoDB, o aplicativo salvará os logs em um arquivo logs.txt localizado no diretório raiz. Quando a conexão for restabelecida, os logs pendentes serão processados e salvos no banco de dados. O arquivo logs.txt será excluído após o processamento.

[[ASSISTIR]](https://youtu.be/T-D1KVIuvjA)
