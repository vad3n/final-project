# Employee Project
## Endpoints
- api/pair - return pair in string format **"Employee 1: {employee1_id} Employee 2: {employee2_id} Time worked together: {pair_time} Projects: { {pair_list_projects} }"**, every project in **{pair_list_projects}** is in format **"Project: {project_id} Time on project: {pair_time_on_project}; "**

Example
```
Employee 1: 1 Employee 2: 2 Time worked together: 100 Projects: { Project: 1 Time on project: 25; Project: 2 Time on project: 75; }
```

- api/employees
    * **GET** - return HTTP status code `200` and list of all employees if list is not empty, otherwise return HTTP status code `204`
    * **POST** - return HTTP status code `200` and message "Successfully create employee", otherwise return HTTP status code `400` and message "Could not create employee"
- api/employees/{id}
    * **GET** - return HTTP status code `200` and employee if employee with that id is found, otherwise return HTTP status code `404` and message "Employee not found"
    * **PUT** - return HTTP status code `200` and message "Successfully update employee" if employee with that id is found, if employee is not found return HTTP status code `404` and message "Employee not found", otherwise return HTTP status code `400` and message "Could not update employee"
    * **DELETE** - return HTTP status code `200` and message "Successfully delete employee" and delete employee from database if employee with that id is found, if employee is not found just return HTTP status code `200` and message "Successfully delete employee"
## Files
- init.sql - contains sql script for database table creation and seeding with 1 entry
- requests.txt - contains curl requests for testing employee endpoints
- file.csv - is placed in employeeproject/src/main/resources and contains sample data