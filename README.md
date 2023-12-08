# Discogs Springboot test API
This is a personal project to test my API skills with spring boot re-doing endpoints that
the [discogs API](https://www.discogs.com/developers) has.

## Domain

The domain is based on the stuff you can see at [discogs](https://discogs.com), but it's not fully implemented.
For now, the domain is based on the following classes. Starting from the most basic one:

- **Album**: a set of tracks with a title, a list of artists, a track list and a list of genres. It also contains a set
of credits, which are the people that participated on the album. It can be a producer, a mixer, a composer, etc.
- **Artist**: a person or group of people that create music. Here we differentiate between:
  - Individual artist: a person that creates music. The difference with a band is that an artist can belong to 
  many bands. Example: [Thom Yorke](https://www.discogs.com/artist/4854-Thom-Yorke). 
  - Band: a group of people that create music. A band can have many artists. 
  Example: [Radiohead](https://www.discogs.com/artist/3840-Radiohead). Note that both individual artists and bands can 
  indeed have name variations or aliases, referring for example to past names tha band/artist had.
- **Release**: a release is the representation of an album, single, etc. In other words, it is the information about the
  physical or digital product that is being sold. It contains:
  - All the album information.
  - Basic artist information. As you can see in a [release detail page](https://www.discogs.com/release/28446010-Glass-Animals-How-To-Be-A-Human-Being)
  not all the artist information is displayed, just the name and the id to build the slug.
  - The release's date and country.
  - The release's format: CD, digital download, vinyl. As you can see while navigating through discogs, they are not 
  necessarily controlled. You can find for a vinyl for example: 4xLP, 2xLP, 12", Double LP 33rpm, etc.
  - The release's label. It will be converted to entity.
  - The release's bar code.

## Installation
This repository uses make commands to run the application, so you need to have make installed in your system.

- Install with ``make install``
- Run with ``make run``

## Testing

Run tests with ``make test``

- You can additionally select a class with ``make test class=ClassName``
- Or run the unit tests with ``make test-unit``

## Endpoints

### Release

- ``GET /releases``: returns all the releases.
- ``GET /releases/{id}``: returns the release with the given id.
- ``GET /releases/scan/{barCode}``: returns the release with the given bar code (simulates the bar code scan feature).ç

## Developing Standards
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