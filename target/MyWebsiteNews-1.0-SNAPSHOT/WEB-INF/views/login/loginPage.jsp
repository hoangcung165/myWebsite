<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section class="ftco-section">
    <div class="container">
        <c:if test="${mess.equals('Login faild')}">
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>Login fial!</strong> You should check in on some of those fields below.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
        <c:if test="${mess.equals('Wellcome')}">
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                <strong>Wellcome!</strong> You can login by account you have registed.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
        <div class="row justify-content-center">
            <div class="col-md-6 text-center mb-5">
                <h2 class="heading-section">Login</h2>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-md-6 col-lg-4">
                <div class="login-wrap p-0">
                    <h3 class="mb-4 text-center">Have an account?</h3>
                    <form action="<c:url value='j_spring_security_check' />"  class="signin-form" method="post">
                        <div class="form-group">
                            <input id="j_user" name="j_user" type="text" class="form-control" placeholder="Username" required>
                        </div>
                        <div class="form-group">
                            <input id="password-field" name="j_password" type="password" class="form-control" placeholder="Password" required>
                            <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="form-control btn btn-primary submit px-3" value="login">Sign In</button>
                        </div>
                        <div class="form-group d-md-flex">
                            <div class="w-50">
                                <label class="checkbox-wrap checkbox-primary">Remember Me
                                    <input type="checkbox" checked>
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                            <div class="w-50 text-md-right">
                                <a href="<c:url value="/register"/>" style="color: #fff">Register Account</a>
                            </div>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    </form>
                    <p class="w-100 text-center">&mdash; Or Sign In With &mdash;</p>
                    <div class="social d-flex text-center">
                        <a href="#" class="px-2 py-2 mr-md-1 rounded"><span class="ion-logo-facebook mr-2"></span> Facebook</a>
                        <a href="#" class="px-2 py-2 ml-md-1 rounded"><span class="ion-logo-twitter mr-2"></span> Twitter</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>