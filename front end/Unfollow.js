import React, { Component } from 'react';


import './Unfollow.css';
class Unfollow extends Component {
  constructor(props)
  {
	  super(props);
	  this.unfollow = this.unfollow.bind(this)
  }
  unfollow() {
    this.props.unfollow(this.props.login);
	}
  render()
  {
  	return (
  		<div className="unfollow-box">
  		<div >
  			<input className="unfollow" type="submit" value="unfollow" onClick={this.unfollow} />
  		</div >
  		</div>
  		)
  }
}
export default Unfollow;