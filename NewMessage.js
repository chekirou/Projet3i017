import React, { Component } from 'react';


import './NewMessage.css';
class NewMessage extends Component {
  constructor()
  {
  	super()
  }
  render()
  {
  	return (
  		<div className="New-message-box">
  		<form>
  			<textarea className="texte" type="text" name="message" />
  			<input className="twister" type="submit" value="twister" />
  		</form>
  		</div>

  		)

  }
}
export default NewMessage;