# skript-votifier-hook

It does what it says! 

This [Skript](https://github.com/bensku/Skript) addon requires:
* Votifier (obviously)
* Java 8

## Events

### Vote Recieved Event

Called every time votifier recieves a vote.

`on [(any|every|raw)] [votifier] vote receiv(e|ed)`

`on [(any|every|raw)] votifier vote`

This event has access to: `event-vote`

### Online Player Vote Event

Called when an online player votes for the server.

`on [online] [player] vote`

This event has access to: `event-player` and `event-vote`

## Expressions

All of the available expressions from this addon are properties of **event-vote**.

### Vote Website

The server list name from where the vote was cast.

`([web]site|server[ ]list|service) [name] of event-vote`

### Voter Username

The voter's submitted username.

`[(voter|sender)] user[(-| )]name of event-vote`

### Voter IP Address

The IP address used when the voter submitted their vote.

`[(voter|sender)] [ip(-| )]address of event-vote`

### Vote Timestamp

The timestamp from when the vote was cast.

`[(voter|sender)] time[(-| )]stamp of event-vote`

## Example Script

```
# This voter is online!
on vote:

    broadcast "&6&l&oVote! &e%username of event-vote% voted on &f&n%website of event-vote%"
    send "&6Congrats&7, %username of event-vote%!" to event-player

# The voter may or may not be online...
on votifier vote:

    send "&9Received a vote." to console
    send "&7-&f Username: %username of event-vote%" to console
    send "&7-&f Website: %server list of event-vote%" to console
    send "&7-&f Address: %ip address of event-vote%" to console
    send "&7-&f Timestamp: %timestamp of event-vote%" to console
```
