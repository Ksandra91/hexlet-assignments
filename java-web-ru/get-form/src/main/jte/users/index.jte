@import exercise.dto.users.UsersPage
@param UsersPage page
@template.layout.page(
content = @`
    <form action="/users" method="get">
        <input type="search" name="term" value="${page.getTerm()}"/>
        <input type="submit" value="Search"/>
    </form>
    @if(page.getUsers().isEmpty())
        <p>No users yet</p>
    @else
        @for(var user : page.getUsers())
            <div>
                <h2>${user.getFirstName()}</h2>
                <p>${user.toString()}</p>
            </div>
        @endfor
    @endif
`
)
