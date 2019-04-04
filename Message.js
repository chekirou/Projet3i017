
import React from 'react';

import './Message.css';

const Message = ({ pseudo, image, message }) => (
  <div className="tweet">
    	<img className="photo" src={image}/>
    <div className="contenu">
    	<div className="pseudo">{pseudo} </div>
    	<div className="message">
    		<p> {message} </p>
    	</div>
    </div>
  </div>
)

export default Message;