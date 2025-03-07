Título do Projeto e modelo de negócio escolhido:
Smart Rh  - Sistema de Gestão de Recursos Humanos

Descrição Geral : 
O Smart RH é uma solução inovadora dedicada à gestão de recursos humanos, projetada para simplificar e otimizar a administração de pessoas dentro de uma organização. Com funcionalidades abrangentes, o sistema possibilita o cadastro de funcionários, o gerenciamento de cargos e a administração de salários de forma integrada e eficaz. Dessa forma, os gestores têm acesso rápido e preciso a informações relevantes sobre seus colaboradores, promovendo uma tomada de decisão mais estratégica e um gerenciamento mais eficiente dos recursos humanos.

Entidade e atributos da entidade:
Funcionários: id, nome, cargo, departamento e salário.

Funcionalidades Principais (CRUD):

Método HTTP	 Endpoint	    	Descrição
GET	     /funcionarios		Lista todos os funcionários.
GET	/funcionarios/{id}		Busca um funcionário pelo ID.
GET	/funcionarios/nome/{nome} 		        Busca um funcionário pelo nome.
POST	 /funcionarios    		Adiciona um novo funcionário.
PUT	/funcionarios		Atualiza um funcionário existente.
DELETE	/funcionarios/{id}		Exclui um funcionário pelo ID.


Tecnologias Utilizadas (banco de dados e backend)
•	Backend: Java com Spring Boot
•	Banco de Dados: MySQL 


