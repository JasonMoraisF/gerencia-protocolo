# CRUD Gerenciamento de Protocolos

- **Descricao**:
  - Nossa API é direcionada para o gerenciamento de protocolos, visando
proporcionar maior eficiência, eficácia e controle sobre a abertura e o encerramento
de protocolos. Por meio dela sera possivel abrir protocolos,sendo necessario preencher os seguintes campos:
_Campo Cliente sendo o campo de criacao de Cliente, nao sendo possivel criar um cliente de outra forma_



##### Abertura de Protocolo:
 1. tipoProtocolo:
    - "reclamacao"
    - "elogio"
    - "informacao"
    - "solicitacao"
    - "consulta"
    - "denuncia"
    - "cancelamento"
      
2. descricao: Maximo de 500 caracteres.
   
3. clienteId:
   - "nome": Maximo de 100 caracteres
   - "cpf": Maximo de 11 caracteres
   - "email": Maximo de 100 caracteres
   - "tipoCliente": "fisico" ou "juridico"
   - "telefones":
     - "ddd": 3 digitos
     - "numero": 9 digitos
     - "tipoTelefone": "Residencial", "Comercial" e "Celular"
  
  _Os telefones so seram criados por meio da criacao de um Cliente ou Titular_

5. canal:
   - "tipoCanal": Preencher com o nome do Canal previamente criado no banco de Dados.
  

##### Atualizacao de Protocolo
1. agilizar: _True_ ou _False_
   
2. devido: _True_ ou _False_
   
3. procedente: _True_ ou _False_
   
4. propensaoBacen: _True_ ou _False_
   
5. departamento:
   - "dpb": _Departamento de Produtos Bancários_
   - "def": _Departamento de Empréstimo e Financiamento_
   - "dc": _Departamento de Contas_
   - "agencia":
   - "ti"
  
6. situacaoProtocolo:
   - "resposta": Maximo de 500 caracteres
   - "status":
     - "redirecionado"
     - "analise"
     - "respondido"
     - "novo"
     - "devolvido"
    
   - "funcionario": ID do funcionario criado previamente no Banco de Dados
  

## Abaixo esta o que e requerido para a criacao das demais colunas.
Sendo possivel a criacao do Titular apenas por meio de abertura de conta.


#### Criacao de Canal de Atendimento
1. "tipoCanal": Maximo de 50 caracteres

#### Criacao de Funcionario
1. "nome": Maximo de 100 caracteres
2. "email": Maximo de 100 caracteres
3. departamento:
   - "dpb": _Departamento de Produtos Bancários_
   - "def": _Departamento de Empréstimo e Financiamento_
   - "dc": _Departamento de Contas_
   - "agencia":
   - "ti"
  
4. cargo:
   - "operador"
   - "gerente"
   - "analista"
_Sera criado automaticamente um id personalizado que consiste em 1 caractere e 6 digitos._


#### Criacao de Conta

1. "agencia": Maximo de 4 digitos.
2. "numeroConta": Maximo de 10 digitos
3. "tipoCliente": "fisico" ou "juridico"
4. "statusConta": _True_ ou _False_ (ativa ou inativa)
5. titular:
   - "cpf": Maximo de 11 caracteres
   - "nome": Maximo de 100 caracteres
   - "email": Maximo de 100 caracteres
   - "Profissao": Maximo de 50 caracteres
   - "telefones":
     - "ddd": 3 digitos
     - "numero": 9 digitos
     - "tipoTelefone": "Residencial", "Comercial" e "Celular"
 _Os telefones so seram criados por meio da criacao de um Cliente ou Titular_
    


     

