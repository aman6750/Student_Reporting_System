<!DOCTYPE html>

<head>
    <meta charset="ISO-8859-1">
    <title>Student Save</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>

<body>
<div class="container my-5">
    <h1 class="text-center">Students Reporting System<br>(Spring Boot & Elasticsearch Application)<br/>
        <a href="/" class="btn btn-danger text-right">Go Home</a>
    </h1>
    <hr>
    <h2>Save Student</h2>

    <form action="#" action="@{/saveStudent}" object="${students}" method="POST">
        <input type="text" field="*{studentRollNo}" placeholder="Student Roll Number" class="form-control mb-4 col-4">
        <input type="text" field="*{studentName}" placeholder="Student Name" class="form-control mb-4 col-4">
        <input type="Integer" field="*{englishMarks}" placeholder="English Marks" class="form-control mb-4 col-4">
        <input type="Integer" field="*{mathsMarks}" placeholder="Maths Marks" class="form-control mb-4 col-4">
        <input type="Integer" field="*{scienceMarks}" placeholder="Science Marks" class="form-control mb-4 col-4">

        <button type="submit" class="btn btn-info col-2"> Save Student</button>
    </form>

    <hr>

    <a href="@{/}" class="link-success"> Back to Student List</a>
</div>
</body>

</html>