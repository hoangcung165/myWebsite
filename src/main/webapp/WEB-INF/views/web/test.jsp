<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="booking" method="post" enctype="multipart/form-data">
    <textarea id="editor" name="detail" style="height: 50px" ></textarea>
    <input type="submit" value="Upload File"/>

</form>
<script src="https://cdn.ckeditor.com/ckeditor5/27.0.0/classic/ckeditor.js"></script>
<script>
    ClassicEditor
        .create( document.querySelector( '#editor' ) )
        .catch( error => {
            console.error( error );
        } );
</script>