# skript-votifier-hook

It does what it says! This addon adds the following syntaxes:

## Events

### Vote Recieved Event

Called when votifier recieves any vote.

`[raw] [votifier] vote receiv(e|ed)`

`[raw] votifier vote`

This event has access to: `event-vote`

### Online Player Vote Event

Called when an online player votes for the server.

`[online] [player] vote`

This event has access to: `event-player` and `event-vote`

## Expressions

All of the available expressions from this addon are properties of **event-vote**.

### Vote Website

The website where the vote was cast.

`([web]site|server[ ]list|service) [name] of event-vote`

### Voter Username

The submitted username of the voter.

`[voter] user[(-| )]name of event-vote`

### Voter IP Address

The IP the voter used while submitting their vote.

`[received] [(voter|sender)] [ip(-| )]address of event-vote`

### Vote Timestamp

The timestamp when the vote was cast.

`[received] [voter] time[(-| )]stamp of event-vote`

## Example Script

```
# This voter is online!
on vote:

    broadcast "&6&l&oVote! &e%username of event-vote% voted on &f&n%website of event-vote%"
    send "&6Congrats&7, %username of event-vote%!" to event-player

# The voter may or may not be online...
on votifier vote:

    broadcast "&9Received a vote."
    broadcast "&7-&f Username: %username of event-vote%"
    broadcast "&7-&f Website: %server list of event-vote%"
    broadcast "&7-&f Address: %ip address of event-vote%"
    broadcast "&7-&f Timestamp: %timestamp of event-vote%"
```
