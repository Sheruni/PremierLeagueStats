package com.example.demo.model;

import javax.persistence.Entity;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

@Entity
public class RandomMatch{
    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;
    private String datePlayed;

    public RandomMatch(String homeTeam, int homeScore, String awayTeam, int awayScore, String date) {
        this.homeTeam = homeTeam;
        this.homeScore = homeScore;
        this.awayTeam = awayTeam;
        this.awayScore = awayScore;
        this.datePlayed = date;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public String getDatePlayed() {
        return datePlayed;
    }

    public void setDatePlayed(String datePlayed) {
        this.datePlayed = datePlayed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RandomMatch that = (RandomMatch) o;
        return homeScore == that.homeScore && awayScore == that.awayScore && Objects.equals(homeTeam, that.homeTeam) && Objects.equals(awayTeam, that.awayTeam) && Objects.equals(datePlayed, that.datePlayed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeam, awayTeam, homeScore, awayScore, datePlayed);
    }

    public static RandomMatch generateMatch() throws IOException {
        List<FootballClub> clubsList =PremierLeagueManager.leagueList;
        List<Match> matchList = PremierLeagueManager.matchList;

        Random rand = new Random();

            int n1 = 0;
            int n2 = 0;
            while (n1 == n2) {
                n1 = (int) (Math.random() * (clubsList.size() ) + 0);
                n2 = (int) (Math.random() * (clubsList.size() ) + 0);
            }
        FootballClub home = clubsList.get(n1);
        FootballClub away = clubsList.get(n2);

        int hScore = rand.nextInt(50);
        int aScore = rand.nextInt(50);

        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        //getTime() returns the current date in default time zone

        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);

        Random random = new Random();
        int minDay = (int) LocalDate.of(2018, 1, 1).toEpochDay();  //The earliest date considered when generating a random match is 1/1/2000
        int maxDay = (int) LocalDate.of(year, month, day).toEpochDay();     //The final date considered when generating a random match is the current date
        long randomDay = minDay + random.nextInt(maxDay - minDay);   //The match is generated using any day between the min and max days

        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);

        String date = String.valueOf(randomDate);

        String[] timepart = date.split("-");   //The generated date is split by the dash to attain the day, month and year separately
        int rYear = Integer.parseInt(timepart[0]);
        int rMonth = Integer.parseInt(timepart[1]);
        int rDay = Integer.parseInt(timepart[2]);

        String nDate = rDay + "/" + rMonth + "/" + "" + rYear;

        matchList.add(new Match(home, away, hScore, aScore, new Date(rDay, rMonth, rYear)));  //The generated match is added to the match list

        Score.setScore(home, away, hScore, aScore);
        //Updates the club details based on the scores

        return new RandomMatch(home.getClubName(), hScore,away.getClubName(), aScore, nDate);

    }

    @Override
    public String toString() {
        return "RandomMatch{" +
                "homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", homeScore=" + homeScore +
                ", awayScore=" + awayScore +
                ", date='" + datePlayed + '\'' +
                '}';
    }
}
