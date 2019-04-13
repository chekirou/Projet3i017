
import React , {Component }from 'react';
import supprimer from './supprimer.png';
import './Message.css';


class Message extends Component {
 constructor(props)
  {
	  super(props);
	  this.goUser = this.goUser.bind(this);
  }
  goUser()
  {
	  this.props.goUser(this.props.pseudo);
  }



render(){
 
 return <div className="tweet">
    		<img className="photo" src={this.props.image}/>
    		<div className="contenu">
    			<div className="pseudo_message" onClick={this.goUser}>{this.props.pseudo}  </div>
				<div className="date_message"> {this.props.date}</div>
    			<div className="message">
    				<p> {this.props.message} </p>
    			</div>
				<div className ="boutons">
					<a><img className="supprimer" src={supprimer}/></a>
				</div>
				
    		</div>
			
		

  		</div>;
}
}
export default Message;