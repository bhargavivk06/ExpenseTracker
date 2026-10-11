# ExpenseTracker

A REST API for tracking expenses, built as my first Spring Boot backend project.

## Tech stack
- Java, Spring Boot
- Spring Data JPA (Hibernate)
- H2 in-memory database
- Tested with Postman

## Structure
`Controller → Service → Repository → Database`

- **Controller:** receives HTTP requests and returns the right status code
- **Service:** the logic, such as checking whether an expense exists before updating or deleting
- **Repository:** talks to the database through `JpaRepository`
- **Model:** the `Expense` entity (`id`, `date`, `reason`, `amount`)

## Endpoints
| Method | URL | Description | Success | Not found |
|---|---|---|---|---|
| POST | `/expenses` | Add an expense | 201 | n/a |
| GET | `/expenses` | List all expenses | 200 | n/a |
| GET | `/expenses/{id}` | Get one expense | 200 | 404 |
| PUT | `/expenses/{id}` | Update an expense | 200 | 404 |
| DELETE | `/expenses/{id}` | Delete an expense | 204 | 404 |

## Example request
`POST /expenses`
{
  "date": "2026-10-11",
  "reason": "Lunch",
  "amount": 250.0
}

## How to run
1. Clone the repo and open it in IntelliJ
2. Run `ExpenseTrackerApplication`
3. Call the API at `http://localhost:8080/expenses`
4. Optional: view the database at `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:expensedb`)

## Notes
- H2 is in-memory, so data resets every time the app restarts.
- Update and delete return 404 for ids that don't exist, instead of creating or ignoring them silently.

## What I learned
Entities and JPA, the layered structure of a Spring Boot app, REST status codes, and testing with Postman.

## Next steps
Add a `category` field, a total-by-category endpoint, and a simple frontend.

