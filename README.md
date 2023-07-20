
# Animanager Emergencies by [@medzdev](https://www.github.com/medzdev)

That repository stores the Animanager's emergency records microsservice. The main goal of this application is to manage the operations with records about the animals care.

The key responsibilities of that service:

- Deploy HTTP endpoints to create, update, read and delete medical records of animals.
- Manage those informations in a persistent structured database.

## Observations
- To run in a persistent database, you should provision it first.
- You should define an application.properties file that suits the project needs. Check the [gist](https://gist.github.com/medzdev/6a3085931a69fe29e3acc888051fe129) to get a copy of that.

## Run Locally

Clone the project

```bash
  git clone https://github.com/medzdev/animanager-emergencies
```

Go to the project directory

```bash
  cd animanager-emergencies
```

Build locally

```bash
  docker build --tag=animanager-emergencies:latest .
```

Run the image in a container

```bash
  docker run --publish 8080:8080 animanager-emergencies
```

## API Reference

### Human records

#### Get all medical records stored in the database.

```http
GET /animanager/emergencies
```

#### Get an specific medical record

```http
GET /animanager/emergencies/${id}
```

| Parameter | Type   | Description                                               |
|:----------|:-------|:----------------------------------------------------------|
| `id`      | `UUID` | **Required**. Id of an individual medical record to fetch |


#### Insert a new medical record

```http
POST /animanager/records/animal
```
| Parameter               | Type           | Description(All of them are Required)                                                                                      |
|:------------------------|:---------------|:---------------------------------------------------------------------------------------------------------------------------|
| ` priority;`            | `String(Enum)` | That attribute should receive the record's priority, only accepting `EMERGENCY`, `URGENCY`, `LOW_URGENCY` or `NON_URGENT`. |
| ` bay;`                 | `String(Enum)` | That attribute should receive the animal's bay, only accepting `A`, `B`, `C`, `D` or `E`.                                  |
| ` symptoms;`            | `String`       | That attribute should receive the animal's symptoms.                                                                       |
| ` procedures;`          | `String`       | That attribute should receive the procedures done to the animal.                                                           |
| ` responsible;`         | `UUID`         | That attribute should receive the  responsible employee's information record UUID.                                         |
| ` status;`              | `String(Enum)` | That attribute should receive the record's status, only accepting `ACTIVE`, `INACTIVE`, `DECEASED` or `DISCHARGED`.        |
| ` animal;`              | `UUID`         | That attribute should receive the animal's information record UUID.                                                        |