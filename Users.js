import React, { Component } from 'react';
import User from './User'
import image from './profil_homme.png'
class Users extends Component {
  	constructor(props)
  	{
  		super(props);
  	}
	render()
	{
		return (
			
				this.props.users.map(({pseudo}) =>
					<User image={image} pseudo={pseudo} goUser={this.props.goUser} />
					
				)


			)
	}
}

export default Users;