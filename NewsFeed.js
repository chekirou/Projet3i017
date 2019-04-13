import React, { Component } from 'react';
import Message from './Message'
class NewsFeed extends Component {
  	constructor(props)
  	{
  		super(props);
  	}
	render()
	{
		return (
			
				this.props.tweets.map(({pseudo, image,date, message}) =>
					<Message pseudo={pseudo} image={image} message = {message} goUser={this.props.goUser} />
					
				)


			)
	}
}

export default NewsFeed;