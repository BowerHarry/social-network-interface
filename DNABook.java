class DNABook implements SocialNetwork {

    String[] names = new String[100];
    boolean[][] friendsArray = new boolean[100][100];
    int pointer = 0;

    public DNABook(){

    }

    @Override
    public void registerUser(String name) {
        names[pointer] = name;
        pointer++;
    }

    @Override
    public void becomeFriends(String name1, String name2) {
        if ((getIndex(name1) != -1) && (getIndex(name2) != -1)) {
            friendsArray[getIndex(name1)][getIndex(name2)] = true;
            friendsArray[getIndex(name2)][getIndex(name1)] = true;
        }
        else {
            System.out.println("Not valid");
        }
    }

    @Override
    public boolean areTheyFriends(String name1, String name2) {
        if ((getIndex(name1) != -1) && (getIndex(name2) != -1)) {
            return friendsArray[getIndex(name1)][getIndex(name2)];
        }

        return false;
    }

    public int getIndex (String name) {
        
        int start = 0;
        int end = pointer;
        while(start <= end){
            int current = ((start + end) / 2);
            if (names[current].compareTo(name) < 0){
                start = current + 1;
            }
            else if (names[current].compareTo(name) > 0) {
                end = current - 1;
            }
            else {
                return current;
            }
        }
        return -1;
    }
}
