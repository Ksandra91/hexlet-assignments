@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@if(page.getErrors() != null)
    <ul>
        @for(var validator : page.getErrors().values())
            @for(var error : validator)
                <li>${error.getMessage()}</li>
            @endfor
        @endfor
    </ul>
@endif

<form action="/articles" method="post">
    <div>
        <label>
            Title
            <input type="title" name="title" value="${page.getTitle()}"/>
        </label>
    </div>
    <div>
        <textarea name="content" placeholder="${page.getContent()}"></textarea>
    </div>

    <input type="submit" value="Submit"/>
</form>

