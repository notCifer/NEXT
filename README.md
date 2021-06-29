Olá seja Bem vindo ao projeto de TCC NextPoint.

REQUISITOS
- MYSQL
- JDK 11 ou superior.


INFORMAÇÕES

-  Antes de iniciar a aplicação percorra pelo caminho main/resources/application.properties e o abra.
-  Modifique o caminho do banco de dados especificado a na " spring.datasource.url=jdbc:mysql://localhost:3307/NEXTPOINT " e simplesmente altere a porta 3307, para a porta configurada em seu MYSQL. Porta padrão(3306).
-  Dentro do MYSQL crie uma database chamada "NEXTPOINT".
-  A aplicação está pronta para ser iniciada.
-  Após criar a database e para garatir total funcionamento da aplicação basta executar a linha de comando no arquivo SQL, encontrado na pasta do projeto.


OBSERVAÇÃO
- O programa está setado para resetar o banco de dados a cada inicilização.
- Depois de iniciar a aplicação uma primeira vez.
- Basta percorrer pelo caminho main/resources/application.properties e abrir.
- Dentro do application.properties você encontrará uma configuração ( spring.jpa.hibernate.ddl-auto=create ), basta alterar "create", para "update".
- Assim a aplicação não irá resetar os dados do banco, apartir de então.


Aproveite o protótipo, para um grande projeto que virá!!

DEVS
- Allan Patrick 
- Alexandre Nardelli
