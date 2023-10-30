import requests
import threading
import re
from datetime import datetime

current_over_value = " "
score_data_per_over = []
wicket_data = []
default_team_score = " "
default_wicket = 0

def get_livescore_data():
    global current_over_value, default_team_score, score_data_per_over, wicket_data, batting_team_score, pattern, default_wicket
    url_response = requests.get('https://www.cricbuzz.com/api/cricket-match/commentary/75542').json()

    innings_data = url_response['miniscore']['matchScoreDetails']['inningsScoreList']
    for innings_score_data in innings_data:
        current_innings = innings_score_data['inningsId']
        if url_response['miniscore']['inningsId'] == current_innings:
            batting_team_name = innings_score_data['batTeamName']
            batting_team_score = innings_score_data['score']
            current_wickets = innings_score_data['wickets']
            current_over = innings_score_data['overs']

            if current_over != current_over_value:
                current_over_value = current_over
                if current_wickets > default_wicket:
                    default_wicket = current_wickets
                    wicket_batsman = url_response['miniscore']['lastWicket']
                    pattern = r"(.*) c (.*) b (.*) (\d+\(\d+\)) - (\d+)/(\d+) in (\d+\.\d+) ov\."
                    match = re.search(pattern, wicket_batsman)
                    if match:
                        batsman_name = match.group(1)
                        runs_scored = match.group(4)
                        team_score = match.group(5)
                        wickets_lost = match.group(6)
                        overs_played = match.group(7)
                        wicket_data.append(
                            f"Over {overs_played} - {batting_team_name} {batting_team_score}/{wickets_lost} {batsman_name} {runs_scored}")
                        print(wicket_data)




                if (current_over - int(current_over)) > 0.5:
                    current_over = round(current_over)
                    score_data_per_over.append(f'Over {current_over}: {batting_team_score}/{current_wickets}')
                    print(score_data_per_over)

                score_data = f'🏏{batting_team_name} {batting_team_score}/{current_wickets}{" "}({current_over})'
                default_team_score = batting_team_score
                print(score_data)

    threading.Timer(5.0, get_livescore_data).start()

# Start fetching live score data
get_livescore_data()

