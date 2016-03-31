"use strict";

var React = require('react');
var Link = require('react-router').Link;

var Header = React.createClass({
	render: function() {
		return(
			<nav className="navbar navbar-default">
				<div className="container-fluid">
					<a href="/" className="navbar-brand">
						<img src="images/logoBetonleague.png" />
					</a>
					<ul className="nav navbar-nav">
						<li><Link to="/">Home</Link></li>
						<li><Link to="/rules">Rules</Link></li>
					</ul>
				</div>
			</nav>
		)
	}
});


module.exports = Header;