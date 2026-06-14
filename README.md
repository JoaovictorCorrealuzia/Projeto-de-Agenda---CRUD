# 📝 Agendador

O projeto agendador funciona seguindo o conceito de **CRUD** (Create, Read, Update e Delete). Foi criada uma **API** que agenda serviços com seus devidos horários, data e serviços, também pode deletar e alterar os serviços já agendados, além de possuir uma **regra de disponibilidade** de a cada uma hora de um serviço já registrado. Projeto **destinado** a ajudar pequenos estabelecimentos, como salões de beleza, barbearias, entre outros comércios.

## Funcionalidades

- Listagem de horários
- Agendar horários
- Deletar horários
- Alterar horários

## API Reference

#### Obter todas as agendas

```http
  GET /BuscarAgendamento
```

| Parametro | Tipo     | Descrição                |
| :-------- | :------- | :------------------------- |
| `date` | `LocalDate` | **Dia** da busca |

#### Agendar um horário

```http
  POST /SalvarAgendamento
```

| Parametro | Tipo     | Descrição                |
| :-------- | :------- |:-------------------------------- |
| `agendamento`      | `JSON` | **Requer** um JSON |

#### Alterar um horário

```http
  PUT /AlterarRegistro
```

| Parametro | Tipo     | Descrição                |
| :-------- | :------- |:-------------------------------- |
| `agendamento` | `JSON` | **Requer** um JSON |
| `cliente` | `String` | **Requer** um cliente com horário agendado |
| `horário` | `LocalDateTime` | **Requer** um novo horário |

#### Deletar um horário

```http
  DELETE /DeletarAgendamento
```

| Parametro | Tipo     | Descrição                |
| :-------- | :------- |:-------------------------------- |
| `cliente` | `String` | **Requer** um cliente com horário agendado |
| `horário` | `LocalDateTime` | **Requer** o horário agendado |


#### JSON

Exemplo de JSON:
```
{
	"servico": "Cortar Cabelo",
	"telefoneClinte": "(47) 9900-9900",
	"profissional": "Cabeleleiro",
	"dataHoraAgendamento":"2026-05-25T14:00:00",
	"cliente": "Josefino"
}	
```

## Aprendizados

Aprendi mais sobre API REST, fazendo um CRUD completo, mexendo com alteração de valores presentes no banco de dados, deleção de valores, arquiteturas e boas práticas de desenvolvimento, como fazer bons commits, testar antes de commitar, entre outras coisas.
## Relacionado

Aqui um outro projeto CRUD.
[Projeto ToDoList](https://github.com/JoaovictorCorrealuzia/ProjetoToDoList)


## Autor

- [JoaovictorCorrealuzia](https://github.com/JoaovictorCorrealuzia)

