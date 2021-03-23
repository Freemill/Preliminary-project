<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="3.3.7/css/bootstrap.css">
	<link rel="stylesheet" href="3.3.7/css/custom.css">
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="3.3.7/js/bootstrap.js"></script>
</head>
<body>
	<div class="container bootstrap snippet">
		<div class="row">
			<div class="col-xs-12">
				<div class="portlet portlet-default">
				<div class="portlet-heading">
					<div class="portlet-title">
						<h4><i class="fa fa-circle text-green"></i>실시간 채팅창</h4>
					</div>		
						<div class="clearfix"></div>
					</div>		
					<div id="chat" class="panel-collapse collapse in">
						<div id="charList" class="portlet-body chat-widget" style="overflow-y:auto; width:auto; height: 600px;">
						</div>
						<div class="portlet-footer">
							<div class="row">
								<div class="form-group col-xs-4">
									<input style="height:40px;" type="text" id="chatName" class="form-control" placeholder="이름" maxlength="8">
								</div>
							</div>
							<div class="row" style="height: 90px;">
								<div class="form-group col-xs-10">
									<textarea style="height:80px;" id="chatContent" class="form-control" placeholder="메세지를 입력하세요" maxlength="100"></textarea>
								</div>
								<div class="form-group col-xs-2">
									<button type="button" class="btn btn-default pull-right" onclick="submitFunction();">전송</button>
									<div class="clearfix"></div>
								</div>
						</div>
					</div>	
				</div>
			</div>
		</div>
	</div>
	</div>
	<div class="alert alert-sucess" id="sucessMessage" style="display: none;">
		<strong>메세지 전송에 성공했습니다.</strong>
	</div>
	<div class="alert alert-danger" id="dangerMessage" style="display: none;">
		<strong>이름과 내용을 모두 입렵해주세여.</strong>
	</div>
	<div class="alert alert-warning" id="warningMessage" style="display: none;">
		<strong>데이터베이스 오류발생</strong>
	</div>




</body>
</html>