
import React , Component from 'react';
import supprimer from './supprimer.png';
import './Message.css';


class Message extends Component {
 constructor(props)
  {
	  super(props);
  }



render(){
 
 return <div className="tweet">
    	<img className="photo" src={this.props.image}/>
    <div className="contenu">
    	<div className="pseudo_message">{this.props.pseudo} </div>
    	<div className="message">
    		<p> {this.props.message} </p>
    	</div>

    </div>
	<div>
	<a><img className="supprimer" src={supprimer}/></a>
	</div>

  </div>;
}
}
export default Message;