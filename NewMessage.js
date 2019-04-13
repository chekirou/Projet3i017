import React, { Component } from 'react';


import './NewMessage.css';
class NewMessage extends Component {
  constructor(props)
  {
	  super(props);
	  this.handleInputChange = this.handleInputChange.bind(this);
	  this.send = this.send.bind(this)
  }
  handleInputChange(event) {
    const target = event.target;
    const value = target.value;
    const name = target.name;

    this.setState({
      [name]: value
    });
  }
  send() {
    this.props.sendMessage(this.state.message)
	}
  render()
  {
  	return (
  		<div className="New-message-box">
  		<div >
  			<textarea className="texte" type="text" name="message" onChange={this.handleInputChange} />
  			<input className="twister" type="submit" value="twister" onClick={this.send} />
  		</div >
  		</div>

  		)

  }
}
export default NewMessage;