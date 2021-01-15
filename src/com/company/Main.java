package com.company;

import java.util.*;

public class Main {
   //Array list
    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Rolling papers 1", "Wiz khalifa");
        album.addSong("Roll up", 3.5);
        album.addSong("Black and yellow", 4.5);
        album.addSong("When i'm gone", 3.8);
        album.addSong("No sleep", 3.7);
        album.addSong("On my level", 4.5);
        album.addSong("Wake up", 4.5);
        album.addSong("Fly Solo", 4.6);
        album.addSong("Cameras", 4.3);
        album.addSong("Roof top", 3.6);
        albums.add(album);
        album = new Album("Rolling paper 2", "Wiz khalifa");
        album.addSong("B OK", 3.4);
        album.addSong("Not now", 4.0);
        album.addSong("Free style", 4.0);
        album.addSong("Going hard", 3.6);
        album.addSong("It's on you", 4.5);
        album.addSong("Fry fry", 3.4);
        album.addSong("Not now", 4.0);
        album.addSong("Blue Hunnids", 4.0);
        album.addSong("Late night messages", 3.6);
        album.addSong("Holy field", 4.5);
        albums.add(album);

        LinkedList<Song> playlist = new LinkedList<Song>();
        albums.get(0).addToPlayList("It's on you", playlist);
        albums.get(0).addToPlayList("Black and yellow", playlist);
        albums.get(0).addToPlayList("Cameras", playlist);
        albums.get(0).addToPlayList("Roof top", playlist);
        albums.get(0).addToPlayList("When i'm gone", playlist);
        albums.get(0).addToPlayList("Fly Solo", playlist);
        albums.get(1).addToPlayList(1, playlist);
        albums.get(1).addToPlayList(4, playlist);
        albums.get(1).addToPlayList(3, playlist);
        albums.get(1).addToPlayList(1, playlist);
        albums.get(1).addToPlayList(3, playlist);
        albums.get(1).addToPlayList(6, playlist);
        albums.get(1).addToPlayList(10, playlist);
        albums.get(1).addToPlayList(12, playlist);
        albums.get(1).addToPlayList(5, playlist);
        albums.get(1).addToPlayList(7, playlist);
        albums.get(1).addToPlayList(8, playlist);
        play(playlist);


    }

    private static void play(LinkedList<Song> playlist) {
        Scanner scanner = new Scanner(System.in);
        boolean quite = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playlist.listIterator();
        if (playlist.size() == 0) {
            System.out.println("No song in playlist..");
            return;
        } else {
            System.out.println("Now plying " + listIterator.next().toString());
            printMenu();

        }

        while (!quite) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Playlist completed");
                    quite = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("we have reached the  end of the list");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are a the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward=false;
                        } else {
                            System.out.println("We are a start of the list");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying" + listIterator.next().toString());
                            forward = true;
                        } else {

                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                     printMenu();
                    break;
                case 6:
                    if(playlist.size()>0)
                    {
                        listIterator.remove();
                        if(listIterator.hasNext())
                        {
                            System.out.println("Now playing"+listIterator.next().toString());
                        }
                        else if(listIterator.hasPrevious())
                        {
                            System.out.println("Now playing"+listIterator.previous());
                        }
                    }
            }


        }
    }


    private static void printMenu() {
        System.out.println("Available options");
        System.out.println("0  - to quite\n");
        System.out.println("1  - play next song\n");
        System.out.println("2  - play previous song\n");
        System.out.println("3  - to replay current song\n");
        System.out.println("4  -to list songs from playlist");
        System.out.println("5  -print available actions");
        System.out.println("6  -delete current playing song");

    }


    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> songs = playList.iterator();
        System.out.println("========");
        while (songs.hasNext()) {
            System.out.println(songs.next().toString());
        }
        System.out.println("========");
    }
}
