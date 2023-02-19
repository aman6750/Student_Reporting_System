<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Student Dashboard</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        #students {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #students td, #students th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #students tr:nth-child(even){background-color: #f2f2f2;}

        #students tr:hover {background-color: #ddd;}

        #students th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #04AA6D;
            color: white;
        }


    </style>
</head>

<body>

<div class="container my-5 ">
    <h1 class="text-center">Students Reporting System<br>(Spring Boot & Elasticsearch Application)<br/>
    </h1>
    <a href="@{/showNewStudentForm}" class="btn btn-primary m-3"> Add Student </a>
    <a href="/" class="btn btn-danger text-right">Go Home</a>

    <button>Semester 1</button> <button>Recent Semester</button>
    <table id="students" border="1" class="table table-striped table-responsive-md">
        <thead class="table-dark">
        <tr>
            <th>StudentRollNo</th>
            <th>StudentName</th>
            <th>EnglishMarks</th>
            <th>MathsMarks</th>
            <th>ScienceMarks</th>

        </tr>
        </thead>
        <tbody>
        <tr each="studentDocument : ${listStudentDocuments}">
            <td text="${studentDocument.studentRollNo}"></td>
            <td text="${studentDocument.studentName}"></td>
            <td Integer="${studentDocument.englishMarks}"></td>
            <td Integer="${studentDocument.mathsMarks}"></td>
            <td Integer="${studentDocument.scienceMarks}"></td>
            <td><a href="@{/showFormForUpdate/{id}(id=${studentDocument.studentRollNo})}" class="btn btn-success">Update</a>
                <a href="@{/deleteStudent/{id}(id=${studentDocument.studentRollNo})}" class="btn btn-danger">Delete</a>
            </td>
        </tr>
        </tbody>
    </table>
</div>
</body>

</html>
