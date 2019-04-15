import React, { Component } from 'react';
import Message from './Message'
class Users extends Component {
  	constructor(props)
  	{
  		super(props);
  	}
	render()
	{
		return (
			
				this.props.users.map(({pseudo}) =>
					<Message pseudo={pseudo} goUser={this.props.goUser} />
					
				)


			)
	}
}

export default Users;