"use strict";

var React = require('react');

var Router = require('react-router');
var Route = Router.Route;

var App = require('./components/app');
var Rules = require('./components/rules/rulesPage');


var routes = (
	<Route path="/" component={App}>
		<Route path="rules" component={Rules} />
	</Route>
);

module.exports = routes;