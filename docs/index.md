# Banco de dados

Logica de user e login não será implementado inicialmente para evitar problemas
desnecessarios.
Link da representação dos banco de dados: https://drawsql.app/teams/base-33/diagrams/bank-system


## Client
id (PK)
type (INDIVIDUAL, BUSINESS)
email
phone
created_at

### Regra de negocio
Client (tipo = INDIVIDUAL)
→ tem dados de CPF

Client (tipo = BUSINESS)
→ tem dados de CNPJ

não pode ser os dois ao mesmo tempo, mais pode permuta

---

## IndividualClient
id (PK)
client_id (FK UNIQUE)
name (string)
cpf (UNIQUE)
birth_date (timestamp)

### Logica de negocio:
- ano atual - birth_date >= 18 (Usuario apenas com 18 anos para cima)

---

## BusinessClient
id (PK)
client_id (FK UNIQUE)
company_name
cnpj (UNIQUE)

---

## Account
id (PK)
number (UNIQUE)
balance (Decimal)
status (ACTIVE, BLOCKED)
client_id (FK)
created_at (Timestamp)

### Logica de negocio
- As contas serão apenas corrente por enquanto, onde ocorre taxa e etc,
nada de logica para rendimento agora. como exemplo type (CHECKING, SAVINGS)
- Caso o cliente realize DDos ou force varias transações o status deve ser blocked. recomenda usar logica de limiting rate.

---

## Transaction:
id
type (DEPOSIT, WITHDRAW, TRANSFER)
amount
fee
origin_account_id
destination_account_id
created_at

### logica de negocio

Taxas (fee)
a taxa será calculadas em cima do valor da transações, podemos cobrar 2% de
cada transações. fee = amount * 0,2

tipo da transações:
type = DEPOSIT
- origin_account_id = NULL (no deposito o dinheiro vem de “fora” do sistema)
- destination_account_id = conta

- type = WITHDRAW
origin_account_id = conta
destination_account_id = NULL (o dinheiro sai para fora do sistema)

---

## PixKey
id (PK)
key (UNIQUE)
type (CPF, EMAIL, PHONE, RANDOM)
account_id (FK)
created_at

### Logica
a chave tem que ser unica para cada conta

input:
  key = "miguel@email.com"
  amount = 100

→ encontra conta destino
→ chama transfer(origin, destination, 100)
