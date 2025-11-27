import javax.sound.midi.*;

/*lilac mrs.greenapple*/
public class SimpleSong {
    public static void main(String[] args) throws Exception {
        Synthesizer synth = MidiSystem.getSynthesizer();
        synth.open();

        MidiChannel[] channels = synth.getChannels();
        channels[2].programChange(0); // Piano for melody3

        int tempo = 600; // 4*BPM, 4 tempo 4 node
        int beatDuration = 60000 / tempo;

        int[][][] melody1 = {
                { { 0 }, { 0 }, { 0 }, { 0 } },

                { { 0 }, { 0 }, { 0 }, { 0 } },
                // [1] 1st node, F,G,B♭,C
                { { 65 }, { 67 }, { 70 }, { 72 } },
                // 2nd node, G,B♭,F
                { { 67 }, { 70 }, { 65 }, { 0 } },
                // 3rd node, G,b♭,C,F+1
                { { 67 }, { 70 }, { 72 }, { 77 } },
                // 4th node, B♭,C,F
                { { 70 }, { 72 }, { 65 }, { 0 } },
                // [2] 5th node, (F).F.G
                { { 0 }, { 0 }, { 65 }, { 67 } },
                // 6th node, B♭,C
                { { 70 }, { 0 }, { 72 }, { 0 } },
                // 7th node, E♭+1,F+1,G+1,F+1
                { { 75 }, { 77 }, { 79 }, { 77 } },
                // 8th node, E♭+1,D+1,C+1,B♭
                { { 75 }, { 74 }, { 72 }, { 70 } },
                // [3] 9th node G+1,B♭
                { { 79 }, { 0 }, { 70 }, { 0 } },
                // 10th node G+1,F+1
                { { 79 }, { 0 }, { 77 }, { 0 } },
                // 11th node, (F+1:77),E♭+1
                { { 0 }, { 0 }, { 75 }, { 0 } },
                // 12th node, D+1,B♭
                { { 74 }, { 0 }, { 70 }, { 0 } },
                // [4] 13th node
                { { 0 }, { 0 }, { 0 }, { 0 } },
                // 14th node
                { { 0 }, { 0 }, { 0 }, { 0 } },
                // 15th node C,A
                { { 72 }, { 0 }, { 0 }, { 69 } },
                // 16th node, A
                { { 0 }, { 0 }, { 0 }, { 0 } },
                // [5] 17th node, F,G,B♭,C
                { { 65 }, { 67 }, { 70 }, { 72 } },
                // 18th node, G,B♭,F
                { { 67 }, { 70 }, { 65 }, { 0 } },
                // 19th node, G,b♭,C,F+1
                { { 67 }, { 70 }, { 72 }, { 77 } },
                // 20th node, B♭,C,F
                { { 70 }, { 72 }, { 65 }, { 0 } },
                // [1] 1st node, (F).F.G
                { { 0 }, { 65 }, { 65 }, { 67 } },
                // 2nd node, B♭,C
                { { 70 }, { 0 }, { 72 }, { 0 } },
                // 3rd node, E♭+1,F+1,G+1,F+1
                { { 75 }, { 77 }, { 79 }, { 77 } },
                // 4th node, E♭+1,D+1,C+1,B♭+1
                { { 75 }, { 74 }, { 72 }, { 70 } },
                // [2] 5th node, B♭+1,B♭
                { { 82 }, { 0 }, { 70 }, { 0 } },
                // 6th node, C,F
                { { 72 }, { 0 }, { 65 }, { 0 } },
                // 7th node, F+1,F
                { { 77 }, { 0 }, { 65 }, { 0 } },
                // 8th node, B♭,F
                { { 70 }, { 0 }, { 65 }, { 0 } },
                // [3] 9th node,
                { { 0 }, { 0 }, { 0 }, { 0 } },
                // 10th node, B♭,C
                { { 0 }, { 0 }, { 70 }, { 72 } },
                // 11th node, F+1,B♭+1
                { { 77 }, { 0 }, { 0 }, { 82 } },
                // 12th node,
                { { 0 }, { 0 }, { 0 }, { 0 } },
        };

        int[][][] melody2 = {
                // [1] 1st node, F,G,B♭,C
                { { 65 }, { 67 }, { 70 }, { 72 } },
                // 2nd node, G,B♭,F
                { { 67 }, { 70 }, { 65 }, { 0 } },
                // 3rd node, G,b♭,C,F+1
                { { 67 }, { 70 }, { 72 }, { 77 } },
                // 4th node, B♭,C,F
                { { 70 }, { 72 }, { 65 }, { 0 } },
                // [2] 5th node, (F).F.G
                { { 0 }, { 0 }, { 65 }, { 67 } },
                // 6th node, B♭,C
                { { 70 }, { 0 }, { 72 }, { 0 } },
                // 7th node, E♭+1,F+1,G+1,F+1
                { { 75 }, { 77 }, { 79 }, { 77 } },
                // 8th node, E♭+1,D+1,C+1,B♭
                { { 75 }, { 74 }, { 72 }, { 70 } },
                // [3] 9th node, G+1E♭+1,B♭
                { { 79, 75 }, { 0 }, { 70 }, { 0 } },
                // 10th node, G+1,F+1B♭
                { { 79 }, { 0 }, { 77, 70 }, { 0 } },
                // 11th node, F+1B♭,E♭
                { { 77, 70 }, { 0 }, { 63 }, { 0 } },
                // 12th node, D,B♭F
                { { 62 }, { 0 }, { 70, 65 }, { 0 } },
                // [4] 13th node, B♭F
                { { 70, 65 }, { 0 }, { 0 }, { 0 } },
                // 14th node, F,G,B♭,C
                { { 65 }, { 67 }, { 70 }, { 72 } },
                // 15th node, D,C,B♭,C
                { { 62 }, { 72 }, { 70 }, { 72 } },
                // 16th node, D,B♭
                { { 62 }, { 0 }, { 70 }, { 0 } },
                // [5] 17th node, F,G,B♭,C
                { { 65 }, { 67 }, { 70 }, { 72 } },
                // 18th node, G,B♭,F
                { { 67 }, { 70 }, { 65 }, { 0 } },
                // 19th node, G,b♭,C,F+1
                { { 67 }, { 70 }, { 72 }, { 77 } },
                // 20th node, B♭,C,F
                { { 70 }, { 72 }, { 65 }, { 0 } },
                // [6] 21st node, (F).F.G
                { { 0 }, { 65 }, { 65 }, { 67 } },
                // 22nd node, B♭,C
                { { 70 }, { 0 }, { 72 }, { 0 } },
                // 23rd node, E♭+1,F+1,G+1,F+1
                { { 75 }, { 77 }, { 79 }, { 77 } },
                // 24th node, E♭+1,D,C,B♭
                { { 75 }, { 74 }, { 72 }, { 70 } },
                // [7] 25th node, G+1E♭+1, B♭
                { { 79, 75 }, { 0 }, { 70 }, { 0 } },
                // 26th node, G+1,F+1B♭
                { { 79 }, { 0 }, { 77, 70 }, { 0 } },
                // 27th node, F+1B♭,E♭
                { { 77, 70 }, { 0 }, { 63 }, { 0 } },
                // 28th node, D,B♭G♭
                { { 62 }, { 0 }, { 70, 66 }, { 0 } },
                // [8] 29th node, B♭G
                { { 70, 67 }, { 0 }, { 0 }, { 0 } },
                // 30th node, F,B♭,D
                { { 0 }, { 65 }, { 70 }, { 62 } },
                // 31th node, F+1,F,B♭,C
                { { 77 }, { 65 }, { 70 }, { 72 } },
                // 32th node, F+1,F
                { { 77 }, { 0 }, { 65 }, { 0 } }
        };

        int[][][] melody3 = {
                // [1] 1st node G-2
                { { 43 }, { 0 }, { 0 }, { 0 } },
                // 2nd node, G-1D-1
                { { 55, 50 }, { 0 }, { 0 }, { 0 } },
                // 3rd node, G-2,G-1D-1
                { { 43 }, { 0 }, { 55, 50 }, { 0 } },
                // 4th node, G-2,E♭-2
                { { 43 }, { 0 }, { 39 }, { 0 } },
                // [2] 5th node, E♭-2, E♭-2
                { { 39 }, { 0 }, { 39 }, { 0 } },
                // 6th node, A-1D-1
                { { 57, 50 }, { 0 }, { 0 }, { 0 } },
                // 7th node,E♭-2,D-1
                { { 39, 50 }, { 0 }, { 0 }, { 0 } },
                // 8th node,E♭-2,D-1
                { { 39, 50 }, { 0 }, { 0 }, { 0 } },
                // [3] 9th node, E♭-2
                { { 39 }, { 0 }, { 0 }, { 0 } },
                // 10th node, B♭-1E♭-1
                { { 58, 51 }, { 0 }, { 0 }, { 0 } },
                // 11th node, E♭-2,B♭-1E♭-1
                { { 39 }, { 0 }, { 58, 51 }, { 0 } },
                // 12th node, E♭-2,B♭-2
                { { 39 }, { 0 }, { 48 }, { 0 } },
                // [4] 13th node, B♭-2
                { { 48 }, { 0 }, { 48 }, { 0 } },
                // 14th node, F-2,B♭-1
                { { 41, 58 }, { 0 }, { 0 }, { 0 } },
                // 15th node, B♭-1B♭-2
                { { 58, 46 }, { 0 }, { 0 }, { 0 } },
                // 16th node, F#-2,F#-1
                { { 53, 41 }, { 0 }, { 0 }, { 0 } },
                // [5] 17th node,G-2
                { { 43 }, { 0 }, { 0 }, { 0 } },
                // 18th node, D-1G-1
                { { 50, 55 }, { 0 }, { 0 }, { 0 } },
                // 19th node, G-2,G-1D-1
                { { 43 }, { 0 }, { 55, 50 }, { 0 } },
                // 20th node, G-2,D-2
                { { 43 }, { 0 }, { 38 }, { 0 } },
                // [6] 21th node, D-2,D-2
                { { 38 }, { 0 }, { 38 }, { 0 } },
                // 22nd node, A-1D-1
                { { 57, 50 }, { 0 }, { 0 }, { 0 } },
                // 23rd node, D-2,D-1
                { { 38, 50 }, { 0 }, { 0 }, { 0 } },
                // 24th node, D-2,D-1
                { { 38, 50 }, { 0 }, { 0 }, { 0 } },
                // [7] 25th node, E♭-2
                { { 39 }, { 0 }, { 0 }, { 0 } },
                // 26th node, B♭-1E♭-1
                { { 58, 51 }, { 0 }, { 0 }, { 0 } },
                // 27th node, E♭-2,B♭-1E♭-1
                { { 39 }, { 0 }, { 58, 51 }, { 0 } },
                // 28th node, E♭-2, G♭-2G♭-1
                { { 39 }, { 0 }, { 42, 54 }, { 0 } },
                // [8] 29th node, G-2G-1,D♭-1
                { { 43, 55 }, { 0 }, { 49 }, { 0 } },
                // 30th node, G♭-1,D-1
                { { 54 }, { 0 }, { 50 }, { 0 } },
                // 31th node, F-2F-1
                { { 41, 53 }, { 0 }, { 0 }, { 0 } },
                // 32th node, F-2,F-1
                { { 41, 53 }, { 0 }, { 0 }, { 0 } }

        };

        // Chord: Gm7, Dm7, EbM7, Bb
        int[][] chords = {
                { 55, 58, 62, 65 }, // Gm7
                { 50, 53, 57, 60 }, // Dm7
                { 51, 55, 58, 62 }, // EbM7
                { 58, 62, 65, 69 } // Bb
        };

        for (int loop = 0; loop < 2; loop++) {
            int[][][] currentMelody;
            if (loop == 0) {
                currentMelody = melody1;
            } else {
                currentMelody = melody2;
            }

            // Play all bars
            for (int i = 0; i < currentMelody.length; i++) {
                int[] currentChord = chords[i % chords.length]; // Loop through chords

                /*
                 * if(0 < loop ){
                 * // Play chords
                 * for (int note : currentChord) {
                 * channels[1].noteOn(note, 70); // Chords (lower volume)
                 * }
                 * }
                 */

                // channels[0].controlChange(64, 127); // Sustain pedal down for melody channel
                // (0) - REMOVED
                if (loop == 1) { // Apply sustain to melody3 only when it's active
                    channels[2].controlChange(64, 127); // Sustain pedal down for melody3 channel (2)
                }

                // Play melody (supporting multiple notes per beat)
                int[][] currentMelodyNode = currentMelody[i];
                int[][] melody3Node = null;
                if (loop == 1 && i < melody3.length) { // Check if melody3 has this node
                    melody3Node = melody3[i];
                }

                for (int j = 0; j < currentMelodyNode.length; j++) { // Iterate through beats in the node
                    int[] notesForBeat = currentMelodyNode[j];
                    int[] melody3NotesForBeat = null;
                    if (melody3Node != null && j < melody3Node.length) {
                        melody3NotesForBeat = melody3Node[j];
                    }

                    // Sustain ON
                    channels[0].controlChange(64, 127);

                    // Note On for currentMelody
                    for (int note : notesForBeat) {
                        if (note != 0) {
                            channels[0].noteOn(note, 100); // Melody (higher volume)
                        }
                    }
                    // Note On for melody3 if applicable
                    if (melody3NotesForBeat != null) {
                        for (int note : melody3NotesForBeat) {
                            if (note != 0) {
                                channels[2].noteOn(note, 100); // melody3 (adjust volume as needed)
                            }
                        }
                    }

                    Thread.sleep(beatDuration); // Play each beat for one beat

                    // Sustain OFF for currentMelody (channel 0) - per beat
                    channels[0].controlChange(64, 0);

                    // Note Off for currentMelody
                    for (int note : notesForBeat) {
                        if (note != 0) {
                            channels[0].noteOff(note);
                        }
                    }
                    // Note Off for melody3 if applicable
                    if (melody3NotesForBeat != null) {
                        for (int note : melody3NotesForBeat) {
                            if (note != 0) {
                                channels[2].noteOff(note);
                            }
                        }
                    }
                } // End of j loop (beats)

                // Sustain OFF for melody3 (channel 2) - per node
                // channels[0].controlChange(64, 0); // Sustain pedal up for melody channel (0)
                // - REMOVED
                if (loop == 1) { // Release sustain for melody3 only when it was active
                    channels[2].controlChange(64, 0); // Sustain pedal up for melody3 channel (2)
                }
            }
        }
        Thread.sleep(500); // waite before closing
        synth.close(); // Close synth once after all loops are done
    }

}
