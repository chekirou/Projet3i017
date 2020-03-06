import React, { Component } from 'react';


import './follow.css';
class Follow extends Component {
  constructor(props)
  {
	  super(props);
	  this.follow = this.follow.bind(this)
  }
  follow() {
    this.props.follow(this.props.login);
	}
  render()
  {
  	return (
  		<div className="follow-box">
  		<div >
  			<input className="follow" type="submit" value="follow" onClick={this.follow} />
  		</div >
  		</div>

  		)

  }
}
export default Follow;