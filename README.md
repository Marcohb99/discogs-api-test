# Discogs Springboot test API
This is a personal project to test my API skills with spring boot simulating
several endpoints that [discogs](https://discogs.com) could have

## Installation
This repository uses make commands to run the application, so you need to have make installed in your system.

- Install with ``make install``
- Run with ``make run``

## Testing

- Run tests with ``make test``
- You can additionally select a class with ``make test class=ClassName``

## Standards
### Commitizen
As you can see, this repository has a [cz.json](cz.json) to indicate the current tag. To follow this conventions,
commits are done this way:

- ``git add .``
- ``cz c``

And released with:

- ``cz bump --changelog -a`` and then
- ``git push && git push --tags``

## Contact
marcohb99@gmail.com