@import exercise.dto.users.UsersPage
@param UsersPage page

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>List of users</title>
</head>
<body>
<h1></h1>
@if(page.getUsers().isEmpty())
    <p>No users yet</p>
@else
    @for(var user : page.getUsers())
        <div>
            <h2><a href="/users/${user.getId()}">${user.getFirstName()}</a></h2>
            <p>${user.toString()}</p>
        </div>
    @endfor
@endif
</body>
</html>