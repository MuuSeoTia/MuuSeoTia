import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        String[] capFortunes = {
                "Your ambitious nature is in overdrive today, Capricorn. You're feeling confident and ready to tackle any challenge that comes your way. Don't be afraid to take risks and push yourself to new heights.",
                "Your practical nature is a great asset today, Capricorn. You're able to see things clearly and make wise decisions that will benefit you in the long run. Trust your instincts and stay true to your values.",
                "Your determination is unwavering today, Capricorn. You have a clear vision of what you want to achieve and you won't stop until you get there. Keep pushing forward and success is sure to come.",
                "Your work ethic is unparalleled, Capricorn. You're willing to put in the time and effort necessary to achieve your goals, and your dedication is an inspiration to others. Keep up the good work!" };
        String[] aquFortunes = {
                "As an Aquarius, you are a natural innovator and always looking for ways to make the world a better place. This month, your creative energy is at an all-time high, and you may find yourself coming up with some truly groundbreaking ideas.",
                "Aquarians are known for their unique perspectives, and this month you'll be using your analytical skills to make some big decisions. Trust your instincts, and don't be afraid to take a calculated risk.",
                "This month, you may find yourself feeling more introspective than usual. Take the time to reflect on your goals and values, and use this insight to guide your actions in the future.",
                "As an Aquarius, you are fiercely independent and value your freedom above all else. This month, you may find yourself wanting to break free from a situation or relationship that is holding you back." };
        String[] pisFortunes = {
                "This is a great time for you to tap into your creative side. Allow your imagination to flow freely and you may find inspiration in unexpected places.",
                "Your intuition is particularly strong right now, so trust your instincts when making important decisions. You may be surprised by the positive outcomes.",
                "Focus on self-care this month. Take the time to nurture your mind, body, and spirit. You'll feel more energized and ready to take on whatever challenges come your way.",
                "You may find yourself feeling more sensitive than usual. Don't be afraid to express your emotions and allow yourself to feel deeply." };
        String[] ariFortunes = {
                "You're a natural leader, Aries. This month, use your charisma to inspire those around you to pursue their passions.",
                "Your competitive spirit will be put to the test this month, Aries. Remember to balance your desire for success with the need to maintain strong relationships with those around you.",
                "Your passion and drive are unmatched, Aries. Don't be afraid to take risks and pursue the things you love.",
                "This month, your impulsiveness may get the best of you, Aries. Try to take a step back and think through your decisions before acting on them." };
        String[] tauFortunes = {
                "You're known for being dependable, Taurus, but sometimes it's okay to shake things up a bit. Take a risk and try something new today, even if it's outside of your comfort zone.",
                "You're a sensual creature, Taurus, and today is a day to indulge in your pleasures. Treat yourself to a luxurious massage or a gourmet meal and savor every moment.",
                "Taurus, your patience and perseverance will pay off today. Keep pushing forward and you'll see progress towards your goals.",
                "Your stubborn nature can sometimes get in the way of your relationships, Taurus. Try to be more open to compromise and understanding others' perspectives." };
        String[] gemFortunes = {
                "Your curiosity and eagerness to learn will lead you down new paths of knowledge and discovery. Keep an open mind and embrace all that the world has to offer.",
                "Your natural charm and wit will draw people to you like a magnet. Use your communication skills to build lasting relationships with those around you.",
                "The duality of your personality may cause inner turmoil, but it's also what makes you so unique and fascinating. Embrace your multifaceted nature and let it shine.",
                "Your sharp intellect and quick thinking will help you excel in any situation. Use your mental prowess to solve problems and overcome obstacles." };
        String[] canFortunes = {
                "You are a deeply emotional person, Cancer, and this month you may find yourself feeling more sensitive than usual. Be sure to take the time to care for yourself and nurture your own needs.",
                "Your intuition is strong this month, Cancer, and you may find yourself receiving important insights and guidance from your dreams and meditations.",
                "You are a natural caretaker, Cancer, and this month you may find yourself called upon to provide support and comfort to a loved one. Your compassionate nature will be a great comfort to those around you.",
                "You have a strong connection to your family and your roots, Cancer, and this month may be a good time to reconnect with your ancestors and explore your heritage." };
        String leoFortunes[] = {
                "Your creativity and self-expression will be at an all-time high this month, Leo. Use this energy to pursue your passions and showcase your talents to the world.",
                "You have a magnetic personality, Leo, and this month you'll attract new opportunities and relationships. Stay confident and don't be afraid to take risks.",
                "Your leadership skills will be put to the test this month, Leo. Embrace your natural authority and inspire those around you to achieve greatness.",
                "You're a natural performer, Leo, and this month is the perfect time to step into the spotlight. Whether it's on stage or in the boardroom, you'll command attention and admiration." };
        String virFortunes[] = {
                "You're known for your meticulous attention to detail, Virgo, but this week it's time to take a step back and trust your intuition. You might be surprised at what you discover when you allow yourself to let go and see where life takes you.",
                "You have a keen sense of responsibility, Virgo, but don't forget to take care of yourself too. This week, make sure to prioritize self-care and do something that brings you joy.",
                "Your analytical mind is one of your greatest strengths, Virgo. This week, use your powers of observation to solve a problem that has been troubling you for a while.",
                "You're a perfectionist by nature, Virgo, but sometimes it's better to aim for progress rather than perfection. This week, focus on making small steps towards your goals rather than trying to achieve everything at once." };
        String libFortunes[] = {
                "This month, you may find yourself caught up in indecision. Remember that it's okay to take your time and make a well-informed decision, even if it takes longer than you'd like.",
                "You have a gift for seeing both sides of an issue, Libra, but be careful not to get so caught up in weighing the pros and cons that you forget to take action.",
                "Your social skills will be in high demand this month, as friends and loved ones turn to you for guidance and support. Lean into your natural charm and diplomacy to help those around you.",
                "You may find yourself feeling particularly creative this month, with a strong urge to express yourself through art, music, or writing. Follow that instinct, Libra!" };
        String scoFortunes[] = {
                "This is a time of transformation for you, Scorpio. You will be shedding your old skin and coming out renewed and refreshed. Embrace this change and let it lead you towards a better path.",
                "Your passion and intensity will be at an all-time high this month, Scorpio. Use this energy to pursue your goals and don't be afraid to take risks.",
                "Your intuition is your greatest strength, Scorpio. Trust your gut and follow your instincts, even if it goes against what others are telling you.",
                "You have a magnetic presence that draws others towards you, Scorpio. Use this charm to your advantage, but be careful not to let it go to your head." };
        String sagFortunes[] = {
                "Your optimism and adventurous spirit will lead you on a thrilling journey this month. Embrace new experiences and don't be afraid to take risks.",
                "You may feel a bit restless this month, but trust your intuition and let your inner compass guide you. Your sense of wanderlust may lead you to exciting opportunities.",
                "You may encounter some challenges this month, but remember that your strength and determination will carry you through. Stay focused on your goals and don't give up.",
                "Your natural curiosity and love of learning will be in full swing this month. Take advantage of opportunities to expand your knowledge and explore new subjects." };
        Card[] cards = {
                new Card("Capricorn", 12, 22, capFortunes),
                new Card("Aquarius", 1, 20, aquFortunes),
                new Card("Pisces", 2, 19, pisFortunes),
                new Card("Aries", 3, 21, ariFortunes),
                new Card("Taurus", 4, 20, tauFortunes),
                new Card("Gemini", 5, 21, gemFortunes),
                new Card("Cancer", 6, 22, canFortunes),
                new Card("Leo", 7, 23, leoFortunes),
                new Card("Virgo", 8, 23, virFortunes),
                new Card("Libra", 9, 23, libFortunes),
                new Card("Scorpio", 10, 22, scoFortunes),
                new Card("Sagittarius", 11, 22, sagFortunes)
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your birthdate (MM/dd/yyyy): ");
        String input = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate birthDate = LocalDate.parse(input, formatter);

        Card zodiacSign = getZodiacSign(birthDate, cards);
        System.out.println("Your zodiac sign is: " + zodiacSign.name);

        String fortune = zodiacSign.getRandomFortune();
        System.out.println("Your fortune: \n" + fortune);

        scanner.close();
    }

    public static Card getZodiacSign(LocalDate birthDate, Card[] zodiacSigns) {
        int day = birthDate.getDayOfMonth();
        int month = birthDate.getMonthValue();

        // loop through all the signs and find the one that matches the birthdate
        for (int i = 0; i < zodiacSigns.length; i++) {
            Card currentSign = zodiacSigns[i];
            Card nextSign = zodiacSigns[(i + 1) % zodiacSigns.length];

            // if the birthdate is between the current sign and the next sign, return the current sign
            if ((month == currentSign.month && day >= currentSign.day) ||
                    (month == nextSign.month && day < nextSign.day)) {
                return currentSign;
            }
        }

        return null;
    }
}