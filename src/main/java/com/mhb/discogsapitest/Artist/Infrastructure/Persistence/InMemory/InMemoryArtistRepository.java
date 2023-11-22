package com.mhb.discogsapitest.Artist.Infrastructure.Persistence.InMemory;

import com.mhb.discogsapitest.Artist.Domain.Artist;
import com.mhb.discogsapitest.Artist.Domain.ArtistRepository;
import com.mhb.discogsapitest.Artist.Domain.Band;
import com.mhb.discogsapitest.Artist.Domain.Exception.ArtistNotFound;
import com.mhb.discogsapitest.Artist.Domain.IndividualArtist;
import com.mhb.discogsapitest.Artist.Domain.ValueObject.BasicArtistInfo;
import com.mhb.discogsapitest.Shared.Domain.NotEmptyString;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import org.springframework.stereotype.Repository;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryArtistRepository implements ArtistRepository {

    @Override
    public Artist byId(SequentialId id) throws ArtistNotFound {
        return artists().stream()
                .filter(artist -> artist.getBasicArtistInfo().id().equals(id))
                .findFirst()
                .orElseThrow(() -> ArtistNotFound.fromId(id));
    }

    private static List<Artist> artists() {
        try {
            return List.of(
                    new Band(
                            new BasicArtistInfo(
                                    new SequentialId(1),
                                    new NotEmptyString("Muse")
                            ),
                            new NotEmptyString("English rock band from Teignmouth, Devon, formed in 1994. The band consists of Matt Bellamy (lead vocals, guitar, keyboards), Chris Wolstenholme (bass guitar, backing vocals), and Dominic Howard (drums)."),
                            Map.of(
                                    1, new NotEmptyString("Rocket Baby Dolls")
                            ),
                            null,
                            Map.of(
                                    1, new NotEmptyString("Matthew Bellamy"),
                                    2, new NotEmptyString("Christopher Wolstenholme"),
                                    3, new NotEmptyString("Dominic Howard")
                            ),
                            List.of(
                                    new URL("https://www.muse.mu/"),
                                    new URL("https://www.musewiki.org/")
                            )
                    ),
                    new IndividualArtist(
                            new BasicArtistInfo(
                                    new SequentialId(2),
                                    new NotEmptyString("David Bowie")
                            ),
                            new NotEmptyString("David Robert Jones (8 January 1947 – 10 January 2016), known professionally as David Bowie, was an English singer, songwriter and actor. He was a leading figure in the music industry and is regarded as one of the most influential musicians of the 20th century. He was acclaimed by critics and musicians, particularly for his innovative work during the 1970s. His career was marked by reinvention and visual presentation, with his music and stagecraft having a significant impact on popular music. During his lifetime, his record sales, estimated at over 100 million records worldwide, made him one of the best-selling music artists of all time. In the UK, he was awarded ten platinum album certifications, eleven gold and eight silver, and released eleven number-one albums. In the US, he received five platinum and nine gold certifications."),
                            Map.of(
                                    21, new NotEmptyString("David Robert Jones"),
                                    22, new NotEmptyString("Davy Jones"),
                                    23, new NotEmptyString("The Thin White Duke"),
                                    24, new NotEmptyString("Ziggy Stardust"),
                                    25, new NotEmptyString("Aladdin Sane"),
                                    26, new NotEmptyString("The Goblin King")
                            ),
                            Map.of(
                                    221, new NotEmptyString("Bowie. D"),
                                    222, new NotEmptyString("Bowie"),
                                    223, new NotEmptyString("Bowie, David")
                            ),
                            List.of(
                                    new URL("https://www.davidbowie.com/")
                            ),
                            new NotEmptyString("David Robert Jones"),
                            null
                    ),
                    new Band(
                            new BasicArtistInfo(
                                    new SequentialId(3),
                                    new NotEmptyString("Califato 3/4")
                            ),
                            new NotEmptyString("Califato 3/4 is a band from Andalusia, formed in 2017. They play a mix of flamenco, jazz, and electronic music."),
                            null,
                            null,
                            Map.of(
                                    311, new NotEmptyString("Curro Morales, Manuel Chaparro, S Curro, Sergio Ruiz Pinto, The Gardener"),
                                    312, new NotEmptyString("Diego Caro"),
                                    313, new NotEmptyString("Esteban Espada"),
                                    314, new NotEmptyString("Lorenzo Soria"),
                                    315, new NotEmptyString("Manuel Chaparro"),
                                    316, new NotEmptyString("S Curro"),
                                    317, new NotEmptyString("Sergio Ruiz Pinto"),
                                    318, new NotEmptyString("The Gardener")
                            ),
                            List.of(
                                    new URL("https://califato34.bandcamp.com/"),
                                    new URL("https://www.youtube.com/channel/UCoM2IXwQ_EmbGn_T2Jt-m-Q")
                            )
                    ),
                    new IndividualArtist(
                            new BasicArtistInfo(
                                    new SequentialId(4),
                                    new NotEmptyString("Jacob Collier")
                            ),
                            new NotEmptyString("Jacob Collier is a British singer, arranger, composer, producer, and multi-instrumentalist based in London, England. Collier's style fuses elements of jazz, a cappella, groove, folk, electronic music, classical music, gospel, soul and improvisation, and often features extreme use of reharmonisation."),
                            null,
                            Map.of(
                                    441, new NotEmptyString("Collier. J")
                            ),
                            List.of(
                                    new URL("https://www.jacobcollier.com/")
                            ),
                            new NotEmptyString("Jacob Collier Moriarty"),
                            null
                    ),
                    new Band(
                            new BasicArtistInfo(
                                    new SequentialId(5),
                                    new NotEmptyString("Squid")
                            ),
                            new NotEmptyString("Squid are a British post-punk band formed in Brighton in 2015. The band consists of drummer/vocalist Ollie Judge, guitarists Louis Borlase and Anton Pearson, bassist Laurie Nankivell and keyboardist Arthur Leadbetter. The band have released two EPs and two singles, and their debut album Bright Green Field is due for release in May 2021."),
                            null,
                            Map.of(551, new NotEmptyString("スクイッド")),
                            Map.of(
                                    511, new NotEmptyString("Anton Pearson"),
                                    512, new NotEmptyString("Arthur Leadbetter"),
                                    513, new NotEmptyString("Laurie Nankivell"),
                                    514, new NotEmptyString("Louis Borlase"),
                                    515, new NotEmptyString("Ollie Judge")
                            ),
                            List.of(
                                    new URL("https://squidband.uk/")
                            )
                    )
            );
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return new java.util.ArrayList<>();
    }
}
