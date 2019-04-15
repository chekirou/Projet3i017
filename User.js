
import React , {Component }from 'react';
import './User.css';


class User extends Component {
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
 
 return <div className="user">
    		
    		<div className="pseudo" onClick={this.goUser}>{this.props.pseudo}  </div>
    		
		
  		</div>;
}
}
export default User;