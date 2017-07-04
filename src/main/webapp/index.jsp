<html ng-app="app">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Users</title>
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.1.1/css/bootstrap.no-icons.min.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular-route.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular-resource.js"></script>
    <script type="text/javascript" src="/resources/app/app.module.js"></script>
    <script type="text/javascript" src="/resources/app/app.config.js"></script>
    <script type="text/javascript" src="/resources/user/user.module.js"></script>
    <script type="text/javascript" src="/resources/user/user.service.js"></script>
    <script type="text/javascript" src="/resources/user/user-detail/user-detail.module.js"></script>
    <script type="text/javascript" src="/resources/user/user-detail/user-detail.component.js"></script>
    <script type="text/javascript" src="/resources/user/user-list/user-list.module.js"></script>
    <script type="text/javascript" src="/resources/user/user-list/user-list.component.js"></script>
</head>
<body>
<div ng-view></div>
</body>
</html>