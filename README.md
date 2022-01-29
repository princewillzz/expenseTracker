# ExpenseTracker

## Setup the project

Assumptions: I have used lombok for getter setter and toString auto-generation during compile time

1. Clone the Repo
2. Create a Database with expense_tracker in your MySQL
3. Change the username and password in application.yml inside the resources folder with your Mysql username and password
4. Use the below command to run the project

```bash
./mvnw spring-boot:run
```

## API Endpoints

Endpoints                  | Method        | Description
-------------------------- | --------------| ---------------
/api/expense | POST | create a new Expense
/api/expense/{expense_id} | PUT | Update an existing expense Expense
api/expense | GET | Get details of all expense
api/expense/{expense_id} | GET | Get details of an expense
api/expense/{expense_id} | DELETE | Delete an expense

api/credit/ | POST | Create a Due
api/credit/{credit_id} | PUT | Update an existing credit details
api/credit | GET | Get all credits details
api/credit/{id} | GET | Get a credit details

/api/credit/repayment?algo=first_in_first_out | GET | Get all repayments based on an algorithm
api/credit/repayment/make-payment/{credit_id} | PUT | make payment for a due credit

### Sample Expense Detail
```
{
    "id": "6bba122b-453c-43ee-bbb9-7f7e674ac6f1",
    "createdAt": "2022-01-28T19:28:01.425+00:00",
    "updatedAt": "2022-01-28T19:57:48.100+00:00",
    "amount": 190.0,
    "reason": "food",
    "location": "Asansol",
    "payment_method": "online"
}
```

### Sample Credit Detail
``` 


    {
        "id": "1a20e422-2428-4a13-a258-7d74694949d9",
        "amount": 2223.0,
        "lender": "l1",
        "repaymentDate": "2101-01-21T00:00:00.000+00:00",
        "note": null,
        "createdAt": null,
        "updatedAt": "2022-01-29T16:02:22.720+00:00",
        "repaymentDone": true
    }

         ```
