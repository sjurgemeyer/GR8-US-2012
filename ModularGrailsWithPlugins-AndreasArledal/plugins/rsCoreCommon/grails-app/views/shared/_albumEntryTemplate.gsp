<g:if test="${editable}">
    <g:link action="edit" id="${album.id}">
        <h2 style="margin-top: 1em;">${album.artist}</h2>
    </g:link>
</g:if>
<g:else><h2 style="margin-top: 1em;">${album.artist}</h2></g:else>
<p>${album.title}</p>
<p>
    <strong>Price:</strong> <g:formatNumber number="${album.price}" currencyCode="USD" type="currency" /><br />
    <strong>In stock:</strong> ${album.itemsInStock}
</p>
<g:if test="${editable}">
    <g:link action="delete" id="${album.id}"><button>Delete</button></g:link>
</g:if>