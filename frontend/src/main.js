window.$ = window.jQuery = require('jquery');

var React = require('react');
var Header = require('./components/common/header');

var App = React.createClass({
	render: function() {
		return (
			<div>
				<Header />
			</div>
		);
	}
});

React.render(<App />, document.getElementById('app'));
