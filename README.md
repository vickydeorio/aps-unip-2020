#  aps-cc-unip
Nosso projeto consiste em um sistema gerenciador de uma faculdade, e atende todos os requisitos pré-definidos pelos professores

# 1. Configuração
Configurações necessárias para rodar o projeto em sua máquina.

## 1.1 Ambiente


Caso você precise buildar o projeto, algumas configurações de ambiente devem ser ajustadas, para satisfazer algumas dependências.
		
	- Java JDK 1.8 ou superior
	- Maven 3.5.0
	
## 2.2 Parâmetros
Para executar o jar contido no projeto manualmente ou buildar o projeto via arquivo executável (build.sh), é necessário passar 3 parâmetros via terminal.

- *Path Absoluto do arquivo Alunos.csv*
Obrigatório, a partir dele será feita a ingestão de dados dos Alunos na aplicação. Ele está localizado em:
> <seu_path_até_o_projeto>/src/main/resources/data/Alunos.csv 
- *Path Absoluto do arquivo Cursos.csv*
Obrigatório, a partir dele será feita a ingestão de dados dos Cursos na aplicação. Ele está localizado em:
> <seu_path_até_o_projeto>/src/main/resources/data/Cursos.csv
- *Path Absoluto do diretório base dos Rendimentos*
Obrigatório, a partir dele será feita a busca dos rendimentos (a partir dos nomes de cursos) e a ingestão de dados dos Rendimentos na aplicação. Ele está localizado em:
> <seu_path_até_o_projeto>/src/main/resources/data/

## 2.3 Build
Deve-se rodar o Script **build.sh**, no diretório base do projeto:
> aps-cc-unip/build.sh

Exemplo de instrução com os parâmetros a serem passados para a aplicação:
> ./build.sh <seu_path_até_o_projeto>/aps-unip-2020/src/main/resources/data/Alunos.csv <seu_path_até_o_projeto>/aps-unip-2020/src/main/resources/data/Cursos.csv /home/victoria.silva/Projetos/aps-unip-2020/src/main/resources/data/

O arquivo acima irá construir o projeto, gerando um novo .jar, com o comando:
> mvn clean compile assembly:single

E depois irá rodar o .jar gerado, que se localiza em:
> /deploy/aps-cc-unip-0.1.0-dist.jar

E, para rodar esse arquivo .jar basta executar o comando:
> java -jar /deploy/aps-cc-unip-0.1.0-dist.jar <seu_path_até_o_projeto>/aps-unip-2020/src/main/resources/data/Alunos.csv <seu_path_até_o_projeto>/aps-unip-2020/src/main/resources/data/Cursos.csv /home/victoria.silva/Projetos/aps-unip-2020/src/main/resources/data/

Assim, você pode apenas rodar o .jar que já existe no diretório **/deploy**, ou executar o arquivo **build.sh**