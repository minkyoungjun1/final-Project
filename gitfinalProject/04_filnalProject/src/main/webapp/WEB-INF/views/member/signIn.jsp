<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,300,400,700&display=swap&subset=korean" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700&display=swap&subset=korean" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
<style>
	$base-bgcolor: #354152;
	$base-color: #7e8ba3;
	$base-font-weight: 300;
	$base-font-size: 1rem;
	$base-line-height: 1.5;
	$base-font-family: Helvetica Neue;
	$base-font-family-fallback: sans-serif;

* {
  box-sizing: border-box;
}

html {
  height: 100%;
}

body {
  background-color: $base-bgcolor;
  color: $base-color;
  font: $base-font-weight {$base-font-size}/{$base-line-height} $base-font-family, $base-font-family-fallback;
  margin: 0;
  min-height: 100%;
}

.align {
  align-items: center;
  display: flex;
  flex-direction: column;
  justify-content: center;


  &__item {

    &--start {
      align-self: flex-start;
    }

    &--end {
      align-self: flex-end;
    }

  }

}

.site {

  &__main {
  }

  &__logo {
    margin-bottom: 2rem;
  }

}

$input-placeholder-color: #7e8ba3;

input {
  border: 0;
  font: inherit;

  &::placeholder {
    color: $input-placeholder-color;
  }

}

.form {

  &__field {
    margin-bottom: 1rem;
  }

  input {
    outline: 0;
    padding: .5rem 1rem;

    &[type="email"],
    &[type="password"] {
      width: 100%;
    }

  }

}

$grid-max-width: 25rem;
$grid-width: 100%;

.grid {
  margin: 0 auto;
  max-width: $grid-max-width;
  width: $grid-width;
}

h2 {
  font-size: 2.75rem;
  font-weight: 100;
  margin: 0 0 1rem;
  text-transform: uppercase;
}

svg {
  height: auto;
  max-width: 100%;
  vertical-align: middle;
}

$link-color: #7e8ba3;

a {
  color: $link-color
}

.register {
  box-shadow: 0 0 250px #000;
  text-align: center;
  padding: 4rem 2rem;
  border-radius : 10%;
  width: 350px;
  height: 450px;

  input {
    border: 1px solid #242c37;
    border-radius: 999px;
    background-color: transparent;
    text-align: center;

    &[type="text"],
    &[type="password"] {
      background-repeat: no-repeat;
      background-size: 1.5rem;
      background-position: 1rem 50%;
    }

    &[type="text"] {
      background-image: url('data:image/svg+xml;charset=UTF-8,<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" fill="#242c37"><path d="M256.017 273.436l-205.17-170.029h410.904l-205.734 170.029zm-.034 55.462l-205.983-170.654v250.349h412v-249.94l-206.017 170.245z"/></svg>');
    }

    &[type="password"] {
      background-image: url('data:image/svg+xml;charset=UTF-8,<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" fill="#242c37"><path d="M195.334 223.333h-50v-62.666c0-61.022 49.645-110.667 110.666-110.667 61.022 0 110.667 49.645 110.667 110.667v62.666h-50v-62.666c0-33.452-27.215-60.667-60.667-60.667-33.451 0-60.666 27.215-60.666 60.667v62.666zm208.666 30v208.667h-296v-208.667h296zm-121 87.667c0-14.912-12.088-27-27-27s-27 12.088-27 27c0 7.811 3.317 14.844 8.619 19.773 4.385 4.075 6.881 9.8 6.881 15.785v22.942h23v-22.941c0-5.989 2.494-11.708 6.881-15.785 5.302-4.93 8.619-11.963 8.619-19.774z"/></svg>');
    }

    &[type="submit"] {
      background-image: linear-gradient(160deg, #8ceabb 0%, #378f7b 100%);
      color: #fff;
      margin-bottom: 6rem;
      width: 100%;
    		}
  		}
	}

.input-box1{
	margin-bottom: 7px; 
	height: 25px; 
	width: 200px;
}

.input-box2{
	height: 25px;
	width: 200px; 
}

.input-box3{
	margin-top: 15px; 
	width: 210px; 
	height: 30px; 
	margin-bottom: 10px;
}
	
.login-form {
	text-decoration: none;
	color: #000;
}

.position{
	padding: 30px;
}
	
</style>
</head>
<body class="align">
  <div class="grid align__item">
    <div class="register">
      <a href="/"><img src="/resources/images/common/logo.png" style="width: 280px"; "height=100px";></a>
      <defs>
	      <linearGradient id="a" x1="0%" y1="0%" y2="0%"><stop offset="0%" stop-color="#8ceabb"/>
	      <stop offset="100%" stop-color="#378f7b"/>
	      </linearGradient>
      </defs>
      <!-- <path fill="url(#a)" d="M215 214.9c-83.6 123.5-137.3 200.8-137.3 275.9 0 75.2 61.4 136.1 137.3 136.1s137.3-60.9 137.3-136.1c0-75.1-53.7-152.4-137.3-275.9z"/> -->
      </svg>
      
      <h2 style="margin-top: 35px;">Sign Up</h2>
      <form action="/signIn.do" method="post" class="form">
        <div class="form__field">
          <input type="text" name="memberId" placeholder="Please enter your ID" class="input-box1" autocomplete=off>
        </div>
        <div class="form__field">
          <input type="password" name="memberPw" placeholder="••••••••••••" class="input-box2" autocomplete=off>
        </div>
        <div class="form__field">
          <input type="submit" value="로그인" class="input-box3">
        </div>
        <div>
        	<div class="position">
	        	<a href="#" class="login-form">ID/PW 찾기</a> | 
    	    	<a href="/joinFrm.do" class="login-form">회원가입</a><br>
        	</div>
        	<div>
        		<a href="#" class="login-form">카카오API 로그인</a> | 
        		<a href="#" class="login-form">네이버API 로그인</a>
        	</div>
        </div>
      </form>
    </div>
  </div>
		
</body>
</html>